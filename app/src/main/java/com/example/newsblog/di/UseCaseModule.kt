package com.example.newsblog.di

import com.example.newsblog.domain.repository.Repository
import com.example.newsblog.domain.useCases.GetHeadLinesUseCase
import com.example.newsblog.domain.useCases.GetNewsByCategoryUseCase
import com.example.newsblog.ui.fragments.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule
{


    @Singleton
    @Provides
    fun provideGetHeadLinesUseCase(repository: Repository) : GetHeadLinesUseCase
        = GetHeadLinesUseCase(repository)

    @Singleton
    @Provides
    fun provideGetNewsByCateGoryUseCase(repository: Repository):GetNewsByCategoryUseCase
        = GetNewsByCategoryUseCase(repository)





}