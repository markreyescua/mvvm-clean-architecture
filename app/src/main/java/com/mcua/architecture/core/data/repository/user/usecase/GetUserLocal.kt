package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class GetUserLocal(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(username: String): User {
        return userRepositoryContract.getUserLocal(username)
    }
}