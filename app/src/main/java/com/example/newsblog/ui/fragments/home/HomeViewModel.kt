package com.example.newsblog.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsblog.domain.useCases.GetHeadLinesUseCase
import com.example.newsblog.domain.useCases.GetNewsByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val headline: GetHeadLinesUseCase,
    private val category: GetNewsByCategoryUseCase
    ):ViewModel()
{



     fun getHeadLines() = viewModelScope.launch ()
    {
        val headline = headline.getHeadLines();
        Timber.tag("1234").d("$headline")
    }


}