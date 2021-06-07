package com.mcua.architecture.framework.data.source.user

import com.mcua.architecture.framework.model.user.User
import com.mcua.architecture.framework.model.user.UserResponse
import com.mcua.architecture.util.exception.NetworkException

class DataSourceUserOffline() : DataSourceUserContract {

    override suspend fun getUser(): UserResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(user: User): UserResponse {
        throw NetworkException("Internet connection needed to create an account.")
    }

    override suspend fun loginUser(username: String, password: String): UserResponse {
        throw NetworkException("Internet connection needed to login.")
    }

}