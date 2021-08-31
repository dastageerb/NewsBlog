package com.example.newsblog.domain.repository

import com.example.newsblog.domain.model.Article

interface Repository
{

    suspend fun getHeadLines() : List<Article>
    suspend fun getNewsByCategory(query:String,Page:Int,PagSize:Int) : List<Article>

}