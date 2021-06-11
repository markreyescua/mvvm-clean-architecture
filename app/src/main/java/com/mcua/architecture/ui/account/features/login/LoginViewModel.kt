package com.mcua.architecture.ui.account.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _user: MutableLiveData<Resource<User>> = MutableLiveData()
    val user: LiveData<Resource<User>> = _user

    fun login(username: String?, password: String?) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            _user.postValue(Resource.Loading())
            if (username.isNullOrBlank() || password.isNullOrBlank()) {
                _user.postValue(Resource.Error(message = "Username and password are required."))
                return@withContext
            }
        }
    }

}