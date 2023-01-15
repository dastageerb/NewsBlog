package com.example.newsblog.domain

import com.example.newsblog.util.ApiResponse

interface NewsRepository {
    suspend fun getHeadLines(): List<Article>
    suspend fun searchNews(query: String): List<Article>
}