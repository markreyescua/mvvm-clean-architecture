package com.mcua.architecture.core.data.repository.user.datasource_contract

import com.mcua.architecture.core.data.model.server.DataResponse
import com.mcua.architecture.core.data.model.User

interface UserDataSourceApiContract {

    suspend fun getProfile(): DataResponse<User>

    suspend fun createUser(user: User): DataResponse<User>

    suspend fun loginUser(username: String, password: String): DataResponse<User>

}