package com.example.newsblog.data.framework.cache.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class ArticleCacheEntity(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val sourceName: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)