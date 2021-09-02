package com.example.newsblog.data.business.network

import com.example.newsblog.data.framework.network.NewsApi
import com.example.newsblog.data.framework.network.mappers.NetworkMapper
import com.example.newsblog.domain.model.Article
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl(private val newsApi: NewsApi,private val networkMapper: NetworkMapper) : RemoteDataSource
{

    override suspend fun getHeadLines(): List<Article>
    {
        return  networkMapper.mapToMode(newsApi.getHeadLines().body()?.articleList!!)
    }

}