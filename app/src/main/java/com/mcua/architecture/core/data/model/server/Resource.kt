package com.mcua.architecture.core.data.model.server

sealed class Resource<T>(
    val data: T? = null,
    val statusCode: Int? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, statusCode: Int, data: T? = null) :
        Resource<T>(data = data, statusCode = statusCode, message = message)
}