package com.example.newsblog.util


sealed class ApiResponse<T>(private val data:T?=null,private val msg:String?=null) {
    class Loading<T> : ApiResponse<T>()
    class Error<T>(val message: String) : ApiResponse<T>(null,message)
    class Success<T>(val data: T) : ApiResponse<T>(data,null)
}