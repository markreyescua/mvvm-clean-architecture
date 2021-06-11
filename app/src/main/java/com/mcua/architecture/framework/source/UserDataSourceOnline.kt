package com.mcua.architecture.framework.source

import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.api.ApiService
import com.mcua.architecture.framework.api.UserDataSourceContract
import com.mcua.architecture.framework.model.User

class UserDataSourceOnline(private val apiService: ApiService) : UserDataSourceContract {

    override suspend fun getUser(): Resource<User> = apiService.getUser()

    override suspend fun createUser(
        username: String,
        password: String,
        email: String,
        firstName: String,
        lastName: String,
        type: String
    ): Resource<User> = apiService.createUser(
        username = username,
        password = password,
        email = email,
        firstName = firstName,
        lastName = lastName,
        type = type
    )

    override suspend fun loginUser(username: String, password: String): Resource<User> =
        apiService.loginUser(
            username = username,
            password = password
        )

}