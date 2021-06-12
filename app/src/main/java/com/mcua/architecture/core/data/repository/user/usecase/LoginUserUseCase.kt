package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.datasource.UserRepository

class LoginUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): Resource<User> {
        return userRepository.loginUser(username, password)
    }
}