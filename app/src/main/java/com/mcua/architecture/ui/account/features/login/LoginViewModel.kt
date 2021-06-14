package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.*
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.model.server.Resource
import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.util.network.NetworkErrorUtil.getResourceError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            _user.postValue(Resource.Loading)
            try {
                val userResponse = userUseCases.loginUser(username!!, password!!)
                val user = userResponse.data!!
                userUseCases.saveUserLocal(user)
                _user.postValue(Resource.Success(user))
            } catch (throwable: Throwable) {
                _user.postValue(getResourceError(throwable))
            }
        }
    }


}