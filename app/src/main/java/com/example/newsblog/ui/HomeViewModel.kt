package com.example.newsblog.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.Article
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.ApiResponse
import com.example.newsblog.util.Constants.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeViewModel constructor(
    private val newsRepository: NewsRepository,
    private val IODispatcher: CoroutineDispatcher,
    private val MainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _newsResponse : MutableStateFlow<ApiResponse<List<Article>>> = MutableStateFlow(ApiResponse.Loading())
    private val newsResponse :StateFlow<ApiResponse<List<Article>>> = _newsResponse

    fun getHeadlines() = viewModelScope.launch(IODispatcher) {
        _newsResponse.value = newsRepository.getHeadLines()
    }

}