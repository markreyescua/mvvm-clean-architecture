package com.mcua.architecture.core.data.model.server

sealed class Resource<out T> {

    data class Success<out T>(val data: T) : Resource<T>()

    data class Error(val code: Int? = null, val error: String? = null) : Resource<Nothing>()

    object NetworkError : Resource<Nothing>()

    object Loading : Resource<Nothing>()

    object Empty : Resource<Nothing>()

}