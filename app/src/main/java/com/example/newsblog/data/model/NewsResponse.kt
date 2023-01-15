package com.example.newsblog.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import okhttp3.internal.ignoreIoExceptions

@Serializable
data class NewsResponse(
    @SerialName("articles")
    val newsArticles: List<NewsArticle>,
)