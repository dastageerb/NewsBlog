package com.example.newsblog.domain.useCase

import com.example.newsblog.domain.NewsRepository

class SearchNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(query:String) = repository.searchNews(query)
}