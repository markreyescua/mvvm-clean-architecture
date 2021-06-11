package com.mcua.architecture.core.data.repository.user.datasource_impl

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceOnline

class UserDataSourceOnlineImpl(private val apiService: ApiService) : UserDataSourceOnline {

    override suspend fun getProfile(): Resource<User> = apiService.getProfile()

    override suspend fun createUser(user: User): Resource<User> = apiService.createUser(user = user)

    override suspend fun login(username: String, password: String): Resource<User> =
        apiService.login(username = username, password = password)

}