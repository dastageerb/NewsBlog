package com.example.newsblog.domain

import com.example.newsblog.util.ApiResponse

interface NewsRepository {
    suspend fun getHeadLines(): ApiResponse<List<Article>>
    suspend fun searchNews(query: String): ApiResponse<List<Article>>
}