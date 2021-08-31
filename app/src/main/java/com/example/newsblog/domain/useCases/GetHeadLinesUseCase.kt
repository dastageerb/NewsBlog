package com.example.newsblog.domain.useCases

import com.example.newsblog.domain.repository.Repository

class GetHeadLinesUseCase(private val repository: Repository)
{

    suspend fun getHeadLines() = repository.getHeadLines()


}