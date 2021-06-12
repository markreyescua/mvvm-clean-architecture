package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApi
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoom

class UserRepository(
    private val userDataSourceAPIContract: UserDataSourceApi,
    private val userDataSourceRoomContract: UserDataSourceRoom
) : UserRepositoryContract {

    override suspend fun getProfile(): BaseResponse<User> {
        return userDataSourceAPIContract.getProfile()
    }

    override suspend fun createUser(user: User): BaseResponse<User> {
        return userDataSourceAPIContract.createUser(user)
    }

    override suspend fun loginUser(username: String, password: String): BaseResponse<User> {
        return userDataSourceAPIContract.loginUser(username, password)
    }

    override suspend fun saveUserLocal(user: User) {
        return userDataSourceRoomContract.saveUserLocal(user)
    }

    override suspend fun getUserLocal(username: String): User {
        return userDataSourceRoomContract.getUserLocal(username)
    }

    override suspend fun deleteUserLocal(username: String) {
        return userDataSourceRoomContract.deleteUserLocal(username)
    }

}