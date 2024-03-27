package com.ivan.fooddelivery.data.remote

sealed class NetworkResult<T> {

    class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>(val code: Int, val message: String?) : NetworkResult<T>()
    class Exception<T>(val e: Throwable) : NetworkResult<T>()
}