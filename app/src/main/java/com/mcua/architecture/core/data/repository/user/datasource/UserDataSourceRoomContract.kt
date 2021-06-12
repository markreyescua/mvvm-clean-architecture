package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.data.model.User

interface UserDataSourceRoomContract {

    suspend fun saveUserLocal(user: User)

    suspend fun getUserLocal(username: String): User

    suspend fun deleteUserLocal(username: String)

}