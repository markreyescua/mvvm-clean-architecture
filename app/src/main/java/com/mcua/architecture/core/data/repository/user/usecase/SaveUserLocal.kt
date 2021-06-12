package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class SaveUserLocal(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(user: User) {
        return userRepositoryContract.saveUserLocal(user)
    }
}