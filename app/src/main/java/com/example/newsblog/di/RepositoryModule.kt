package com.example.newsblog.di

import com.example.newsblog.data.NewsRepoImpl
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.domain.useCase.GetHeadLineUseCase
import com.example.newsblog.domain.useCase.SearchNewsUseCase
import com.example.newsblog.ui.HomeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepoImpl(get(), get(named("IO"))) }
}

val viewModelModule = module {
    single { HomeViewModel(get(named("IO")), get(named("MAIN")),get(),get()) }
}

val dispatchersModule = module {
    single<CoroutineDispatcher>(named("IO")) { Dispatchers.IO }
    single<CoroutineDispatcher>(named("MAIN")) { Dispatchers.Main }
}

val useCaseModule = module {
    single { GetHeadLineUseCase(get()) }
    single { SearchNewsUseCase(get()) }
}
