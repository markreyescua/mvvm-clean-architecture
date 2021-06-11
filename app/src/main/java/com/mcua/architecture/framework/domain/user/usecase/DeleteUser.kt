package com.mcua.architecture.framework.domain.user.usecase

import com.mcua.architecture.framework.domain.user.repository.UserRepository
import com.mcua.architecture.framework.model.User

class DeleteUser(private val userRepository: UserRepository) {
    suspend fun execute(user: User) {
        return userRepository.deleteUser(user)
    }
}