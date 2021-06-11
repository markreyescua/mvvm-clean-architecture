package com.mcua.architecture.framework.api

import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.model.User

interface UserDataSourceContract {

    suspend fun getUser(): Resource<User>

    suspend fun createUser(
        username: String,
        password: String,
        email: String,
        firstName: String,
        lastName: String,
        type: String,
    ): Resource<User>

    suspend fun loginUser(
        username: String,
        password: String
    ): Resource<User>

}