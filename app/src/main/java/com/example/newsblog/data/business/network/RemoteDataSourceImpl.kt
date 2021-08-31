package com.example.newsblog.data.business.network

import com.example.newsblog.data.framework.network.NewsApi
import com.example.newsblog.data.framework.network.mappers.NetworkMapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val newsApi: NewsApi, val networkMapper: NetworkMapper)
{


}