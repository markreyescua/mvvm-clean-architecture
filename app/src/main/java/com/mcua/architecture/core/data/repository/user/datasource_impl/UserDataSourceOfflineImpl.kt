package com.mcua.architecture.core.data.repository.user.datasource_impl

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.db.UserDao
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceOffline

class UserDataSourceOfflineImpl(private val userDao: UserDao) : UserDataSourceOffline {

    override suspend fun saveUserLocal(user: User) {
        return userDao.saveUser(user)
    }

    override suspend fun getUserLocal(username: String): Resource<User> {
        return userDao.getUser(username)
    }

    override suspend fun deleteUserLocal(username: String) {
        return userDao.deleteUser(username)
    }

}