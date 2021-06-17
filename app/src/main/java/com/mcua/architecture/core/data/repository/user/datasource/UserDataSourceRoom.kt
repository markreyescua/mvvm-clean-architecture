package com.mcua.architecture.core.data.repository.user.datasource

import com.mcua.architecture.core.data.db.dao.UserDao
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource_contract.UserDataSourceRoomContract

class UserDataSourceRoom(private val userDao: UserDao) : UserDataSourceRoomContract {

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