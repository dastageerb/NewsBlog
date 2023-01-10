package com.example.newsblog.data.model


import kotlinx.serialization.Serializable

@Serializable
data class NewsArticle(
    val description: String,
    val source: Source,
    val title: String,
    val urlToImage: String
)