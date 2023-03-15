package com.example.newsblog.data

import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.ApiResponse
import com.example.newsblog.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

class NewsRepoImpl(
    private val api: NewsApiService,
    private val coroutineDispatcher: CoroutineDispatcher,
) : NewsRepository {
    override suspend fun getHeadLines() = invoke { api.getHeadLines() }

    override suspend fun searchNews(query: String) = invoke { api.searchNews(query) }

    private suspend fun <T> invoke(apiCall: suspend () -> Response<T>): ApiResponse<T> {
        return withContext(coroutineDispatcher) {
            return@withContext try {
                val response = apiCall.invoke()
                ApiResponse.Success(response.body()!!)
            } catch (e: Exception) {
                Timber.tag(Constants.TAG).d("getHeadLines: %s", e.message)
                ApiResponse.Error(e.message.toString())
            }
        }
    }
}