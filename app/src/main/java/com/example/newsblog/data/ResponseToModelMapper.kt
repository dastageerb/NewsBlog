package com.example.newsblog.data

import com.example.newsblog.data.model.NewsArticle
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.EntityMapper

class ResponseToModelMapper : EntityMapper<NewsResponse,NewsArticle,Article> {

    override fun mapResponseToListOfModel(response: NewsResponse): List<Article> {
        return response.newsArticles.map {
            mapResponseToModel(it)
        }
    }

    override fun mapResponseToModel(remoteEntity: NewsArticle): Article {
        return Article(
            description = remoteEntity.description,
        sourceName = remoteEntity.source.name,
        title = remoteEntity.title,
        urlToImage = remoteEntity.urlToImage,
        )
    }
}