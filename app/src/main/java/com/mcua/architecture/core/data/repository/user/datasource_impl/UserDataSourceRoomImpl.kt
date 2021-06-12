package com.mcua.architecture.core.data.repository.user.datasource_impl

import com.mcua.architecture.core.data.db.UserDao
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceRoom

class UserDataSourceRoomImpl(private val userDao: UserDao) : UserDataSourceRoom {

    override suspend fun saveUserLocal(user: User) {
        return userDao.saveUser(user)
    }

    override suspend fun getUserLocal(username: String): User {
        return userDao.getUser(username)
    }

    override suspend fun deleteUserLocal(username: String) {
        return userDao.deleteUser(username)
    }

}