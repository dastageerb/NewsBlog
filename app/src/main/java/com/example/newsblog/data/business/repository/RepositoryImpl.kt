package com.example.newsblog.data.business.repository

import com.example.newsblog.data.business.cache.LocalDataSource
import com.example.newsblog.data.business.network.RemoteDataSource
import com.example.newsblog.domain.model.Article
import com.example.newsblog.domain.repository.Repository

class RepositoryImpl(private val localDataSource: LocalDataSource,
                     private val remoteDataSource: RemoteDataSource) : Repository

{

    override suspend fun getHeadLines(): List<Article>
    {
        return remoteDataSource.getHeadLines()
    } /// getHeadLines closed

    override suspend fun getNewsByCategory(query: String, Page: Int, PagSize: Int): List<Article>
    {
        TODO("Not yet implemented")
    } // getNewsByCategory closed


} // RepositoryImpl closed