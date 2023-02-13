package com.example.newsblog.domain.useCase

import com.example.newsblog.domain.NewsRepository

class GetHeadLineUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke() = repository.getHeadLines()
}