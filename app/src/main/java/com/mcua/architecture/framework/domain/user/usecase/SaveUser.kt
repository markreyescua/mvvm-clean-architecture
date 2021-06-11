package com.mcua.architecture.framework.domain.user.usecase

import com.mcua.architecture.framework.domain.user.repository.UserRepository
import com.mcua.architecture.framework.model.User

class SaveUser(private val userRepository: UserRepository) {
    suspend fun execute(user: User) {
        return userRepository.saveUser(user)
    }
}