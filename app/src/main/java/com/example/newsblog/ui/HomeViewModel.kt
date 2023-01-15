package com.example.newsblog.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsblog.domain.NewsRepository
import com.example.newsblog.util.Constants.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeViewModel constructor(
    val newsRepository: NewsRepository,
    val IODispatcher: CoroutineDispatcher,
    val MainDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun getHeadlines() = viewModelScope.launch(MainDispatcher) {
        Timber.tag(TAG).d("viewModel" + newsRepository.getHeadLines().toString())
    }

}