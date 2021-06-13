package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mcua.architecture.core.data.repository.user.UserUseCases

class LoginViewModelFactory(
    private val userUseCases: UserUseCases
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(userUseCases) as T
    }
}