package com.example.newsblog.data.framework.network.mappers

import com.example.newsblog.data.framework.EntityMapper
import com.example.newsblog.data.framework.network.model.ArticleNetworkEntity
import com.example.newsblog.domain.model.Article
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<ArticleNetworkEntity, Article>
{
    override fun mapToModel(entity: ArticleNetworkEntity): Article = Article(
        author = entity.author ,
        content =  entity.content,
        description = entity.description,
        publishedAt = entity.publishedAt,
        sourceName = entity.source?.name,
        title =  entity.title ,
        url = entity.url,
        urlToImage = entity.urlToImage
    )


    fun mapToMode(list: List<ArticleNetworkEntity>):List<Article> =
            list.map { mapToModel(it) }

}