package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.data.repository.user.UserRepository

class DeleteUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String) {
        return userRepository.deleteUserLocal(username)
    }
}