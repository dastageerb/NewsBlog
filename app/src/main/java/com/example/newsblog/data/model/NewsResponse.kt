package com.example.newsblog.data.model


import com.example.newsblog.data.model.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("articles")
    val articles: List<Article>,
    @SerialName("status")
    val status: String
)