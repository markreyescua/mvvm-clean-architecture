package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class SaveUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User) {
        return userRepository.saveUserLocal(user)
    }
}