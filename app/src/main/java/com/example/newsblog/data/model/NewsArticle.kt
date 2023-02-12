package com.example.newsblog.data.model


import kotlinx.serialization.Serializable

@Serializable
data class NewsArticle(
    val description: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val urlToImage: String? = null
)