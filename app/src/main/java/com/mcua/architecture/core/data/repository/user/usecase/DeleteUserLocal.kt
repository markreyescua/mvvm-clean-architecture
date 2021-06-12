package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.repository.user.UserRepository

class DeleteUserLocal(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(username: String) {
        return userRepositoryContract.deleteUserLocal(username)
    }
}