package com.mcua.architecture.framework.domain.user.repository

import com.mcua.architecture.framework.model.User
import com.mcua.architecture.base.Resource

interface UserRepository {
    suspend fun saveUser(user: User)
    suspend fun getUser(username: String): Resource<User>
    suspend fun deleteUser(user: User)
}