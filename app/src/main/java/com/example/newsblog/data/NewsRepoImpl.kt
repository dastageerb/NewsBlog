package com.example.newsblog.data

import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.EntityMapper
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class NewsRepoImpl(
    val api: NewsApiService,
    val coroutineDispatcher: CoroutineDispatcher,
    val responseToModelMapper: ResponseToModelMapper
) : NewsRepository {

    override suspend fun getHeadLines(): ApiResponse<List<Article>> {
        return withContext(coroutineDispatcher) {
            return@withContext try {
                api.getHeadLines().apply {
                    ApiResponse.Success(this.body()
                        ?.let { responseToModelMapper.mapResponseToListOfModel(it) })
                }
            } catch (e: Exception) {
                ApiResponse.Error(e.message.toString())
            }
        }
    }

    override suspend fun searchNews(query: String): ApiResponse<List<Article>> {

    }

}