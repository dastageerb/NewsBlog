package com.example.newsblog.data.framework.network

import com.example.newsblog.data.framework.network.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi
{

    @GET("top-headlines")
    suspend fun getHeadLines(
        @Query("country") country:String="us",
        @Query("page") page:Int =1,
        @Query("pageSize") pageSize:Int=5
    ): Response<NewsResponse>



}