package com.example.newsblog.data.api

import com.example.newsblog.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getHeadLines(@Query("country") country: String = "us"): Response<NewsResponse>

    @GET("everything")
    suspend fun searchNews(@Query("q") query: String): Response<NewsResponse>
}