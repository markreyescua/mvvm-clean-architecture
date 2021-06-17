package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.data.model.server.DataResponse
import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource_contract.UserDataSourceApiContract

class UserDataSourceApi(private val apiService: ApiService) : UserDataSourceApiContract {

    override suspend fun getProfile(): DataResponse<User> = apiService.getProfile()

    override suspend fun createUser(user: User): DataResponse<User> = apiService.createUser(user = user)

    override suspend fun loginUser(username: String, password: String): DataResponse<User> =
        apiService.loginUser(username = username, password = password)

}