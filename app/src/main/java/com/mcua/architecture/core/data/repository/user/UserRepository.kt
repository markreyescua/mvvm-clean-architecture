package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceApi
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceRoom
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApiImpl
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoomImpl

class UserRepository(
    private val userDataSourceApi: UserDataSourceApiImpl,
    private val userDataSourceRoom: UserDataSourceRoomImpl
) : UserDataSourceApi, UserDataSourceRoom {

    override suspend fun getProfile(): BaseResponse<User> {
        return userDataSourceApi.getProfile()
    }

    override suspend fun createUser(user: User): BaseResponse<User> {
        return userDataSourceApi.createUser(user)
    }

    override suspend fun loginUser(username: String, password: String): BaseResponse<User> {
        return userDataSourceApi.loginUser(username, password)
    }

    override suspend fun saveUserLocal(user: User) {
        return userDataSourceRoom.saveUserLocal(user)
    }

    override suspend fun getUserLocal(username: String): User {
        return userDataSourceRoom.getUserLocal(username)
    }

    override suspend fun deleteUserLocal(username: String) {
        return userDataSourceRoom.deleteUserLocal(username)
    }

}