package com.example.newsblog.domain.useCases

import com.example.newsblog.domain.repository.Repository

class GetNewsByCategoryUsesCase(private val repository: Repository)
{

    suspend fun getNewsByCategory(query:String,page:Int,pageSize:Int)
        = repository.getNewsByCategory(query,page,pageSize)

}