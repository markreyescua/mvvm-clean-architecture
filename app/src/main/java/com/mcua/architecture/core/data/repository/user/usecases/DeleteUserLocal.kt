package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.data.repository.user.UserRepository

class DeleteUserLocal(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String) {
        return userRepository.deleteUserLocal(username)
    }
}