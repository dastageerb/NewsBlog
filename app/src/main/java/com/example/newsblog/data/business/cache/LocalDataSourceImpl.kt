package com.example.newsblog.data.business.cache

import com.example.newsblog.domain.model.Article

class LocalDataSourceImpl () : LocalDataSource
{

    override suspend fun getHeadLine(): List<Article>
    {
        TODO("Not yet implemented")
    }

}