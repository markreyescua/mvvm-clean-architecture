package com.mcua.architecture.framework.data.source

import com.mcua.architecture.framework.model.User
import com.mcua.architecture.base.Resource
import com.mcua.architecture.framework.data.source.UserDataSourceOffline

class UserRepository(private val dataSource: UserDataSourceOffline) {

    suspend fun saveUser(user: User) = dataSource.saveUser(user)

    suspend fun getUser(username: String): Resource<User> = dataSource.getUser(username)

    suspend fun deleteUser(username: String) = dataSource.deleteUser(username)

}