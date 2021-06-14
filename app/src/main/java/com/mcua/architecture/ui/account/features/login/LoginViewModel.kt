package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mcua.architecture.core.data.model.server.ErrorResponse
import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.util.network.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    fun login(username: String?, password: String?) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            if (username.isNullOrBlank() && password.isNullOrBlank()) {
                return@withContext
            }
            try {
                val userResponse = userUseCases.loginUser(username!!, password!!)
                val user = userResponse.data!!
                userUseCases.saveUserLocal(user)
                Timber.e(user.toJsonString())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> {
                        Timber.e("IOException")
                        ResultWrapper.NetworkError
                    }
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = getErrorMessage(throwable)
                        Timber.e(errorResponse?.message)
                        ResultWrapper.GenericError(code, errorResponse)
                    }
                    else -> {
                        Timber.e("GenericError")
                        ResultWrapper.GenericError(null, null)
                    }
                }
            }
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