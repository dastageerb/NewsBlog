package com.example.newsblog.util

sealed class ApiResponse<out T> {
    object Idle : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
    class Error(val message: String) : ApiResponse<String>()
    class Success<T>(val data: T? = null) : ApiResponse<T>()
}