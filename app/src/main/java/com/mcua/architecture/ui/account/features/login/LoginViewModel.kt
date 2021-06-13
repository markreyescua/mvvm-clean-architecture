package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcua.architecture.core.data.repository.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
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
            } catch (e: Exception) {
                Timber.e(e.localizedMessage?.toString() ?: "Unknown exception")
            }
        }
    }

}