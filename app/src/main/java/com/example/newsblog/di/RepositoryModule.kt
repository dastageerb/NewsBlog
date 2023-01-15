package com.example.newsblog.di

import com.example.newsblog.data.DataToDomainEntityMapper
import com.example.newsblog.data.NewsRepoImpl
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.ui.HomeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepoImpl(get(), get(named("IO")), get()) }
}

val viewModelModule = module {
    single { HomeViewModel(get(), get(named("IO")), get(named("MAIN"))) }
}

val dispatchersModule = module {
    single<CoroutineDispatcher>(named("IO")) { Dispatchers.IO }
    single<CoroutineDispatcher>(named("MAIN")) { Dispatchers.Main }
}

val mapperModule = module {
    single { DataToDomainEntityMapper() }
}
