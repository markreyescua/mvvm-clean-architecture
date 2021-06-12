package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.repository.user.datasource.UserRepository

class GetUserLocalUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Resource<User> {
        return userRepository.getUserLocal(username)
    }
}