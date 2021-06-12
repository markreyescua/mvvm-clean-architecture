package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User

interface UserDataSourceOffline {

    suspend fun saveUserLocal(user: User)

    suspend fun getUserLocal(username: String): Resource<User>

    suspend fun deleteUserLocal(username: String)

}