package com.example.newsblog.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@ExperimentalSerializationApi
val netWorkModule = module{

    single{
        Interceptor {
            it
                .proceed(
                    it.request()
                        .newBuilder()
                        .addHeader("","")
                        .build())
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
            Retrofit.Builder()
            .client(get())
            .addConverterFactory(Json.asConverterFactory(("application/json".toMediaType())))
            .baseUrl("BASE_URL")
            .build()
    }
}