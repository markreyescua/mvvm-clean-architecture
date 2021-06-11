package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User

interface UserDataSourceOffline {

    suspend fun saveUser(user: User)

    suspend fun getUser(username: String): Resource<User>

    suspend fun deleteUser(username: String)

}