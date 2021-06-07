package com.mcua.architecture.framework.data.source.user

import com.mcua.architecture.framework.model.user.User
import com.mcua.architecture.framework.model.user.UserResponse

interface DataSourceUserContract {
    suspend fun getUser(): UserResponse
    suspend fun createUser(user: User): UserResponse
    suspend fun loginUser(username: String, password: String): UserResponse
}