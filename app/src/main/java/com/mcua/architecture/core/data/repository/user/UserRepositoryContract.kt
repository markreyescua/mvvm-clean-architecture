package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User

interface UserRepositoryContract {

    /***** api ******/
    suspend fun getProfile(): BaseResponse<User>

    suspend fun createUser(user: User): BaseResponse<User>

    suspend fun loginUser(username: String, password: String): BaseResponse<User>

    /***** room ******/
    suspend fun saveUserLocal(user: User)

    suspend fun getUserLocal(username: String): User

    suspend fun deleteUserLocal(username: String)

    /***** graphql ******/
    // TODO: add graphql repository here

}