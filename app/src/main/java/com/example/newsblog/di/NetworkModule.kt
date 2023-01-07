package com.example.newsblog.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit


@ExperimentalSerializationApi
val netWorkModule = module{


    single {
            Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory((MediaType.get("application/json"))))
            .baseUrl("BASE_URL")
            .build()
    }


}