package com.example.newsblog.di

import com.example.newsblog.BuildConfig
import com.example.newsblog.data.api.NewsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@ExperimentalSerializationApi
val netWorkModule = module {

    single {
        Interceptor {
            it.proceed(
                it.request()
                    .newBuilder()
                    .addHeader("Authorization", BuildConfig.API_KEY)
                    .build()
            )
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(json.asConverterFactory(("application/json".toMediaType())))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    fun providesNewsApi(retrofit: Retrofit) = retrofit.create(NewsApiService::class.java)

    single<NewsApiService> { providesNewsApi(get()) }
}