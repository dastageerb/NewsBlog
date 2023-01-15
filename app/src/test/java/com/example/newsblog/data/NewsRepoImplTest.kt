package com.example.newsblog.data

import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.data.model.NewsArticle
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.data.model.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class NewsRepoImplTest {

    @Mock
    lateinit var newsApiService:NewsApiService

    private var repoImpl:NewsRepoImpl?=null

    private var responseToModelMapper:ResponseToModelMapper?=null

    @Before
    fun before(){
        responseToModelMapper = ResponseToModelMapper()
        repoImpl = NewsRepoImpl(newsApiService,Dispatchers.IO, responseToModelMapper!!)
    }

    @Test
    fun shouldGetHeadlines() {
        runBlocking {
            val expected = Response.success(newsResponse(5))
            `when`(newsApiService.getHeadLines()).thenReturn(expected)
            val response = repoImpl?.getHeadLines()
            assertEquals(responseToModelMapper?.mapResponseToListOfModel(expected.body()!!),response)
            verify(newsApiService, times(1)).getHeadLines()
        }
    }

        fun newsResponse(size:Int):NewsResponse {
            val list = mutableListOf<NewsArticle>()
            for (i in 1 .. size) {
                list.add(NewsArticle("news description", Source("Tribune"),"News Title","imageUrl"))
            }
            return NewsResponse(list)
        }


}