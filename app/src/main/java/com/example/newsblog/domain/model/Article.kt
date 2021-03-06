package com.example.newsblog.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val sourceName: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)