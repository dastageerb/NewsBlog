package com.example.newsblog.di

import com.example.newsblog.data.business.cache.LocalDataSource
import com.example.newsblog.data.business.network.RemoteDataSource
import com.example.newsblog.data.business.repository.RepositoryImpl
import com.example.newsblog.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule
{



    @Provides
    @Singleton
    fun provides(localDataSource: LocalDataSource,remoteDataSource: RemoteDataSource):Repository
    = RepositoryImpl(localDataSource,remoteDataSource)


}