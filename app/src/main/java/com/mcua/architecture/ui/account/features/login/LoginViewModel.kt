package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.model.server.ErrorResponse
import com.mcua.architecture.core.data.model.server.Resource
import com.mcua.architecture.core.data.repository.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val _user: MutableLiveData<Resource<User>> = MutableLiveData()
    val user: LiveData<Resource<User>> = _user

    fun login(username: String?, password: String?) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            if (username.isNullOrBlank() && password.isNullOrBlank()) {
                return@withContext
            }
            _user.postValue(Resource.Loading())
            try {
                val userResponse = userUseCases.loginUser(username!!, password!!)
                val user = userResponse.data!!
                userUseCases.saveUserLocal(user)
                _user.postValue(Resource.Success(user))
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> {
                        _user.postValue(
                            Resource.Error(
                                message = "You need an internet connection to perform this action.",
                                statusCode = 500
                            )
                        )
                    }
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = getErrorMessage(throwable)
                        _user.postValue(
                            Resource.Error(
                                message = errorResponse?.message!!,
                                statusCode = code
                            )
                        )
                    }
                    else -> {
                        _user.postValue(Resource.Error(message = "Unknown Error", statusCode = 500))
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