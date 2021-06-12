package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcua.architecture.MyApp
import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    @Inject
    lateinit var userUseCases: UserUseCases

    init {
        initializeDagger()
    }

    fun login(username: String?, password: String?) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val user = User(
                userId = "asg982tgj-32598lsdf",
                username = "markreyescua",
                email = "mark.r.cua@gmail.com",
                type = "customer",
                firstName = "Mark Edison",
                lastName = "Cua"
            )
            userUseCases.saveUserLocal(user)
            val userResponse: BaseResponse<User> =
                userUseCases.loginUser(user.username, "Connect1@1")
            Timber.e("${userResponse.data?.toJsonString()}")
        }
    }

    private fun initializeDagger() = MyApp.appComponent.inject(this)


}