package com.mcua.architecture.framework.data.source

import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.model.User

interface UserDataSourceOffline {

    suspend fun saveUser(user: User)

    suspend fun getUser(username: String): Resource<User>

    suspend fun deleteUser(username: String)

}