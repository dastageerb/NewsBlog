package com.example.newsblog.di

import com.example.newsblog.BuildConfig
import com.example.newsblog.data.business.network.RemoteDataSource
import com.example.newsblog.data.business.network.RemoteDataSourceImpl
import com.example.newsblog.data.framework.EntityMapper
import com.example.newsblog.data.framework.network.NewsApi
import com.example.newsblog.data.framework.network.mappers.NetworkMapper
import com.example.newsblog.data.framework.network.model.ArticleNetworkEntity
import com.example.newsblog.domain.model.Article
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{


    @Singleton
    @Provides
    fun provideOkHttpClient() :OkHttpClient
    {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

        return  OkHttpClient.Builder()
            .addInterceptor{ chain ->  
                val request = chain.request()
                val  newRequest = request.newBuilder().addHeader("Authorization",BuildConfig.API_KEY)
                chain.proceed(newRequest.build())
            }
            .addInterceptor(interceptor)
            .readTimeout(30,TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .build()

    }

    @Singleton
    @Provides
    fun provideMoshiConverterFactory():MoshiConverterFactory =
            MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofitClient(moshi: MoshiConverterFactory,client: OkHttpClient):Retrofit =
            Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(moshi)
                .build()


    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

    @Singleton
    @Provides
    fun provideNetworkMapper():EntityMapper<ArticleNetworkEntity,Article> = NetworkMapper()

    @Singleton
    @Provides
    fun remoteDataSource(api:NewsApi,networkMapper: NetworkMapper) :RemoteDataSource = RemoteDataSourceImpl(api,networkMapper)



}