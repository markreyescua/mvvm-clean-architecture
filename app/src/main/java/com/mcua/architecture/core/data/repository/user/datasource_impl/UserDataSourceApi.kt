package com.mcua.architecture.core.data.repository.user.datasource_impl

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceAPIContract

class UserDataSourceApi(private val apiService: ApiService) : UserDataSourceAPIContract {

    override suspend fun getProfile(): BaseResponse<User> = apiService.getProfile()

    override suspend fun createUser(user: User): BaseResponse<User> = apiService.createUser(user = user)

    override suspend fun loginUser(username: String, password: String): BaseResponse<User> =
        apiService.loginUser(username = username, password = password)

}