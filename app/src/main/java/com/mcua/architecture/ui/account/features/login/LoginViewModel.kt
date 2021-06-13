package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcua.architecture.MyApp
import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.util.ext.safeLogError
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
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
                safeLogError(user.toJsonString())
            } catch (e: Exception) {
                safeLogError(msg = e.localizedMessage.toString())
            }
        }
    }

}