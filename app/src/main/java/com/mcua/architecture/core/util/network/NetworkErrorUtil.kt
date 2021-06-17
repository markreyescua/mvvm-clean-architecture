package com.mcua.architecture.core.util.network

import com.google.gson.Gson
import com.mcua.architecture.core.data.model.server.ErrorResponse
import com.mcua.architecture.core.data.model.server.Resource
import retrofit2.HttpException
import java.io.IOException

object NetworkErrorUtil {

    fun getResourceError(throwable: Throwable) = when (throwable) {
        is IOException -> {
            Resource.NetworkError("You need an internet connection to perform this action.")
        }
        is HttpException -> {
            val code = throwable.code()
            val errorResponse = getErrorMessage(throwable)
            Resource.Error(
                error = errorResponse?.message!!,
                code = code
            )
        }
        else -> {
            Resource.NetworkError("You need an internet connection to perform this action.")
        }
    }

    private fun getErrorMessage(throwable: HttpException): ErrorResponse? {
        return try {
            throwable.response()?.errorBody()?.string()?.let { errorBody ->
                return Gson().fromJson(errorBody, ErrorResponse::class.java)
            }
        } catch (exception: Exception) {
            ErrorResponse()
        }
    }

}