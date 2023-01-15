package com.example.newsblog.data

import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.Constants.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

class NewsRepoImpl(
    val api: NewsApiService,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mapper: ResponseToModelMapper
) : NewsRepository {
    override suspend fun getHeadLines() = getArticles { api.getHeadLines() }

    override suspend fun searchNews(query: String) = getArticles { api.searchNews(query) }

    private suspend fun getArticles(response: suspend () -> Response<NewsResponse>): List<Article> {
        return withContext(coroutineDispatcher) {
            return@withContext try {
                mapper.mapResponseToListOfModel(response.invoke().body()!!)
            } catch (e: Exception) {
                Timber.tag(TAG).d("getHeadLines: " + e.message)
                emptyList()
            }
        }
    }
}