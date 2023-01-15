package com.example.newsblog.data

import com.example.newsblog.data.model.NewsArticle
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.EntityMapper
import com.example.newsblog.util.Constants.TAG
import timber.log.Timber

class DataToDomainEntityMapper : EntityMapper<NewsResponse, NewsArticle, Article> {

    override fun mapResponseToListOfModel(response: NewsResponse): List<Article> {
        Timber.tag(TAG).d("check "+response.newsArticles.toString())
        return response.newsArticles.map {
            mapResponseToModel(it)
        }
    }

    override fun mapResponseToModel(remoteEntity: NewsArticle): Article {
        return Article(
            description = remoteEntity.description,
            sourceName = remoteEntity.source?.name,
            title = remoteEntity.title,
            urlToImage = remoteEntity.urlToImage,
        )
    }
}