package com.example.newsblog.util

sealed class ApiResponse<T>(private val data:T?=null,private val msg:String?=null) {
    object Idle : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
    class Error(message: String) : ApiResponse<String>(null,message)
    class Success<T>(data: T? = null) : ApiResponse<T>(data,null)
}