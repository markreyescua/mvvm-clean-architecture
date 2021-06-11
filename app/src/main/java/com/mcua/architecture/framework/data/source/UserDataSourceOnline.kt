package com.mcua.architecture.framework.data.source

import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.model.User

interface UserDataSourceOnline {

    suspend fun getUser(): Resource<User>

    suspend fun createUser(user: User): Resource<User>

    suspend fun loginUser(username: String, password: String): Resource<User>

}