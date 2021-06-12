package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User

interface UserDataSourceApi {

    suspend fun getProfile(): BaseResponse<User>

    suspend fun createUser(user: User): BaseResponse<User>

    suspend fun loginUser(username: String, password: String): BaseResponse<User>

}