package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User

interface UserRepositoryContract {

    /***** api ******/
    suspend fun getProfile(): Resource<User>

    suspend fun createUser(user: User): Resource<User>

    suspend fun loginUser(username: String, password: String): Resource<User>

    /***** room ******/
    suspend fun saveUserLocal(user: User)

    suspend fun getUserLocal(username: String): User

    suspend fun deleteUserLocal(username: String)

    /***** graphql ******/
    // TODO: add graphql repository here

}