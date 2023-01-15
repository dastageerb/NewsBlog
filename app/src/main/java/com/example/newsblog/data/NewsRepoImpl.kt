package com.example.newsblog.data

import android.util.Log.d
import androidx.annotation.VisibleForTesting
import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.Constants.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber.Forest.tag

class NewsRepoImpl(
    private val api: NewsApiService,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mapper: DataToDomainEntityMapper
) : NewsRepository {
    override suspend fun getHeadLines() = getArticles { api.getHeadLines() }

    override suspend fun searchNews(query: String) = getArticles { api.searchNews(query) }

    @VisibleForTesting
    suspend fun getArticles(apiCall: suspend () -> Response<NewsResponse>): List<Article> {
        return withContext(coroutineDispatcher) {
            return@withContext try {
                val response = apiCall.invoke()
                tag(TAG).d(" api Response${response.code()}")
                mapper.mapResponseToListOfModel(response.body()!!)
            } catch (e: Exception) {
                tag(TAG).d("getHeadLines: %s", e.message)
                emptyList()
            }
        }
    }
}