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
        repoImpl = NewsRepoImpl(newsApiService,Dispatchers.IO, DataToDomainEntityMapper())
    }

    @Test
    fun shouldGetHeadlinesWhenResponseIsSuccess() {
        runBlocking {
            val expectedResponse = Response.success(newsResponse(5))
            `when`(newsApiService.getHeadLines()).thenReturn(expectedResponse)

            val response = repoImpl?.getHeadLines()

            assertTrue(response is ApiResponse.Success)
            verify(newsApiService, times(1)).getHeadLines()
        }
    }

    @Test
    fun shouldNotGetHeadlinesWhenResponseIsError() {
        runBlocking {
            val expectedResponse = Response.error<NewsResponse>(404, errorResponseBody())
            `when`(newsApiService.getHeadLines()).thenReturn(expectedResponse)

            val response = repoImpl?.getHeadLines()

            assertTrue(response is ApiResponse.Error)
            verify(newsApiService, times(1)).getHeadLines()
        }
    }

    @Test
    fun shouldGetSearchedNewsWhenResponseIsSuccess() {
        runBlocking {
            val expectedResponse = Response.success(newsResponse(10))
            `when`(newsApiService.searchNews(searchQuery)).thenReturn(expectedResponse)

            val response = repoImpl?.searchNews(searchQuery)

            assertTrue(response is ApiResponse.Success)
            verify(newsApiService, times(1)).searchNews(searchQuery)
        }
    }

    @Test
    fun shouldNotGetSearchedNewsWhenResponseIsError() {
        runBlocking {
            val expectedResponse = Response.error<NewsResponse>(404, errorResponseBody())
            `when`(newsApiService.searchNews(searchQuery)).thenReturn(expectedResponse)

            val response = repoImpl?.searchNews(searchQuery)


            assertTrue(response is ApiResponse.Error)
            verify(newsApiService, times(1)).searchNews(searchQuery)
        }
    }

    @Test
    fun shouldGetListOfArticlesWhenInvokedMethodResponseIsSuccess() {
        runBlocking {
            val expectedResponse = Response.success(newsResponse(3))
            `when`(newsApiService.getHeadLines()).thenReturn(expectedResponse)

            val response = repoImpl?.getArticles { newsApiService.getHeadLines() }

            assertTrue(response is ApiResponse.Success)
            verify(newsApiService, times(1)).getHeadLines()
        }
    }

    @Test
    fun shouldGetListOfArticlesWhenInvokedMethodResponseIsError() {
        runBlocking {
            val expectedResponse = Response.error<NewsResponse>(404, errorResponseBody())
            `when`(newsApiService.getHeadLines()).thenReturn(expectedResponse)

            val response = repoImpl?.getArticles { newsApiService.getHeadLines() }


            assertTrue(response is ApiResponse.Error)
            verify(newsApiService, times(1)).getHeadLines()
        }
    }

    private fun errorResponseBody():ResponseBody {
        return "{status:error,message:UnAuthorized}".toResponseBody()
    }

    private fun newsResponse(size: Int): NewsResponse {
        val list = mutableListOf<NewsArticle>()
        for (i in 1..size) {
            list.add(NewsArticle("news description", Source("Tribune"), "News Title", "imageUrl"))
        }
        return NewsResponse(list)
    }
}