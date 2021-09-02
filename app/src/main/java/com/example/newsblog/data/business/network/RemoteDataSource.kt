package com.example.newsblog.data.business.network

import com.example.newsblog.data.framework.network.NewsApi
import com.example.newsblog.data.framework.network.mappers.NetworkMapper
import com.example.newsblog.domain.model.Article
import retrofit2.Response

interface RemoteDataSource
{
    suspend fun getHeadLines():List<Article>

}