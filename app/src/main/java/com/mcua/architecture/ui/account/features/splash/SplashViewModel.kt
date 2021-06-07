package com.mcua.architecture.ui.account.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _timeout = MutableLiveData<Boolean>()
    val timeout: LiveData<Boolean> get() = _timeout

    fun startSplashScreenTimeout() = viewModelScope.launch {
        delay(3000)
        _timeout.postValue(true)
    }

}