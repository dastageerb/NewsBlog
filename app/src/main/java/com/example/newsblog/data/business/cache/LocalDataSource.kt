package com.example.newsblog.data.business.cache

import com.example.newsblog.domain.model.Article

interface LocalDataSource
{

    suspend fun getHeadLine():List<Article>;

}