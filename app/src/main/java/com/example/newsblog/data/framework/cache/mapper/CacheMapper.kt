package com.example.newsblog.data.framework.cache.mapper

import com.example.newsblog.data.framework.EntityMapper
import com.example.newsblog.data.framework.cache.model.ArticleCacheEntity
import com.example.newsblog.domain.model.Article

class CacheMapper:EntityMapper<ArticleCacheEntity,Article>
{

    override fun mapToModel(entity: ArticleCacheEntity)
        = Article(
        author = entity.author ,
        content =  entity.content,
        description = entity.description,
        publishedAt = entity.publishedAt,
        sourceName = entity.sourceName,
        title =  entity.title ,
        url = entity.url,
        urlToImage = entity.urlToImage
    )

    fun mapFromModel(article: Article) :ArticleCacheEntity
            = ArticleCacheEntity(

        author = article.author ,
        content =  article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        sourceName = article.sourceName,
        title =  article.title ,
        url = article.url,
        urlToImage = article.urlToImage)




} // cacheMapper closed