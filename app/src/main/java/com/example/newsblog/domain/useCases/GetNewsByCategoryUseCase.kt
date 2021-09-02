package com.example.newsblog.domain.useCases

import com.example.newsblog.domain.repository.Repository

class GetNewsByCategoryUseCase(private val repository: Repository)
{

    suspend fun getNewsByCategory(query:String,page:Int,pageSize:Int)
        = repository.getNewsByCategory(query,page,pageSize)

}