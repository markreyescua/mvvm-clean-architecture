package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User

interface UserDataSourceOnline {

    suspend fun getProfile(): Resource<User>

    suspend fun createUser(user: User): Resource<User>

    suspend fun login(username: String, password: String): Resource<User>

}