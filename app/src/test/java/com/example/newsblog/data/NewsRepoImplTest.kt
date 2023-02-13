package com.example.newsblog.data

import com.example.newsblog.data.api.NewsApiService
import com.example.newsblog.data.model.NewsArticle
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.data.model.Source
import com.example.newsblog.util.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class NewsRepoImplTest {

    @Mock
    lateinit var newsApiService: NewsApiService

    private var repoImpl:NewsRepoImpl?=null

    private val searchQuery = "tech"

    @Before
    fun before() {
        repoImpl = NewsRepoImpl(newsApiService,Dispatchers.IO)
    }

    @Test
    fun shouldGetHeadlinesWhenResponseIsSuccess() {
        runBlocking {
            val expectedResponse = Response.success(newsResponse(5))
            `when`(newsApiService.getHeadLines()).thenReturn(expectedResponse)

            val response = repoImpl?.getHeadLines()

            verify(newsApiService, times(1)).getHeadLines()
            assertTrue(response is ApiResponse.Success)
        }
    }

    @Test
    fun shouldNotGetHeadlinesWhenResponseIsError() {
        runBlocking {
            `when`(newsApiService.getHeadLines()).thenThrow(NullPointerException("Response is null"))


            val response = repoImpl?.getHeadLines()

            verify(newsApiService, times(1)).getHeadLines()
            assertTrue(response is ApiResponse.Error)
        }
    }

    @Test
    fun shouldGetSearchedNewsWhenResponseIsSuccess() {
        runBlocking {
            val expectedResponse = Response.success(newsResponse(10))
            `when`(newsApiService.searchNews(searchQuery)).thenReturn(expectedResponse)

            val response = repoImpl?.searchNews(searchQuery)

            verify(newsApiService, times(1)).searchNews(searchQuery)
            assertTrue(response is ApiResponse.Success)
        }
    }

    @Test
    fun shouldNotGetSearchedNewsWhenResponseIsError() {
        runBlocking {
            `when`(newsApiService.searchNews(searchQuery)).thenThrow(NullPointerException("Response is null"))
            val response = repoImpl?.searchNews(searchQuery)


            assertTrue(response is ApiResponse.Error)
            verify(newsApiService, times(1)).searchNews(searchQuery)
        }
    }

    private fun newsResponse(size: Int): NewsResponse {
        val list = mutableListOf<NewsArticle>()
        for (i in 1..size) {
            list.add(NewsArticle("news description", Source("Tribune"), "News Title", "imageUrl"))
        }
        return NewsResponse(list)
    }
}