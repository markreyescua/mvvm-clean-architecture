package com.mcua.architecture.framework.domain.user.usecase

import com.mcua.architecture.framework.data.source.UserRepository
import com.mcua.architecture.framework.model.User

class SaveUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User) {
        return userRepository.saveUser(user)
    }
}