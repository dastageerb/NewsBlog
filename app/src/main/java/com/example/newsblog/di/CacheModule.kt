package com.example.newsblog.di

import com.example.newsblog.data.business.cache.LocalDataSource
import com.example.newsblog.data.business.cache.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule
{

    @Provides
    @Singleton
    fun provideLocalDataSource():LocalDataSource = LocalDataSourceImpl()



}