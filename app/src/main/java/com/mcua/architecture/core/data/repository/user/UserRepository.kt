package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceRoom
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceAPI
import com.mcua.architecture.core.data.repository.user.datasource.UserRepository

class UserRepository(
    private val userDataSourceAPI: UserDataSourceAPI,
    private val userDataSourceRoom: UserDataSourceRoom
) : UserRepository {

    override suspend fun getProfile(): Resource<User> {
        return userDataSourceAPI.getProfile()
    }

    override suspend fun createUser(user: User): Resource<User> {
        return userDataSourceAPI.createUser(user)
    }

    override suspend fun loginUser(username: String, password: String): Resource<User> {
        return userDataSourceAPI.loginUser(username, password)
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