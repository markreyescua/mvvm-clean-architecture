package com.mcua.architecture.framework.data.source

import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.data.ApiService
import com.mcua.architecture.framework.model.User

class UserRemoteApi(private val apiService: ApiService) {

    suspend fun getUser(): Resource<User> = apiService.getUser()

    suspend fun createUser(user: User): Resource<User> = apiService.createUser(user)

    suspend fun loginUser(username: String, password: String): Resource<User> =
        apiService.loginUser(
            username = username,
            password = password
        )

}