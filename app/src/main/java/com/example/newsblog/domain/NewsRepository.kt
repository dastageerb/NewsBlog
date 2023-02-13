package com.example.newsblog.domain

import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.util.ApiResponse

interface NewsRepository {
    suspend fun getHeadLines(): ApiResponse<NewsResponse>
    suspend fun searchNews(query: String): ApiResponse<NewsResponse>
}