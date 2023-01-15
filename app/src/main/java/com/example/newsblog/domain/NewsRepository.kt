package com.example.newsblog.domain

interface NewsRepository {
    suspend fun getHeadLines(): List<Article>
    suspend fun searchNews(query: String): List<Article>
}