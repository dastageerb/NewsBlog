package com.example.newsblog.data

import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.util.ApiResponse
import com.example.newsblog.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

class ApiHelper(private val IODispatcher:CoroutineDispatcher) {
//
//
//    suspend fun getArticles<T>(apiCall: suspend () -> Response<T>):  {
//        return withContext(IODispatcher) {
//            return@withContext try {
//                val response = apiCall.invoke()
//                ApiResponse.Success(mapper.mapResponseToListOfModel(response.body()!!))
//            } catch (e: Exception) {
//                Timber.tag(Constants.TAG).d("getHeadLines: %s", e.message)
//                ApiResponse.Error(e.message.toString())
//            }
//        }
//    }
}

