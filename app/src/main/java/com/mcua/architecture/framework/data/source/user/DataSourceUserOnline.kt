package com.mcua.architecture.framework.data.source.user

import com.mcua.architecture.framework.data.ApiService
import com.mcua.architecture.framework.model.user.User
import com.mcua.architecture.framework.model.user.UserResponse

class DataSourceUserOnline(private val service: ApiService) : DataSourceUserContract {

    override suspend fun getUser(): UserResponse = service.getUser()

    override suspend fun createUser(user: User): UserResponse = service.createUser(
        username = user.username,
        password = user.password!!,
        email = user.email,
        firstName = user.firstName,
        lastName = user.lastName,
        type = user.type,
    )

    override suspend fun loginUser(username: String, password: String): UserResponse =
        service.loginUser(username = username, password = password)
}