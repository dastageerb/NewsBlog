package com.example.newsblog.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    @SerialName("description")
    val description: String,
    @SerialName("source")
    val source: Source,
    @SerialName("title")
    val title: String,
    @SerialName("urlToImage")
    val urlToImage: String
)