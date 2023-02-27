package com.example.newsblog.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.domain.useCase.GetHeadLineUseCase
import com.example.newsblog.domain.useCase.SearchNewsUseCase
import com.example.newsblog.util.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel constructor(
    private val IODispatcher: CoroutineDispatcher,
    private val MainDispatcher: CoroutineDispatcher,
    private val getHeadLineUseCase: GetHeadLineUseCase,
    private val searchNewsUseCase: SearchNewsUseCase

) : ViewModel() {

    private val _newsResponse : MutableStateFlow<ApiResponse<NewsResponse>> = MutableStateFlow(ApiResponse.Loading())
    val newsResponse :StateFlow<ApiResponse<NewsResponse>> = _newsResponse

    fun getHeadlines() = viewModelScope.launch(IODispatcher) {
        _newsResponse.value = getHeadLineUseCase()
    }

    fun searchHeadlines(searchQuery:String) = viewModelScope.launch(IODispatcher) {
        _newsResponse.value = searchNewsUseCase(searchQuery)
    }

    // viewState
    private var _loadApi by mutableStateOf(true)
    var loadApi:Boolean = _loadApi

    fun loadApi(load:Boolean) {
        _loadApi = load
    }
}