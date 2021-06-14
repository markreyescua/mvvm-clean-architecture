package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.model.server.DataResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class LoginUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): DataResponse<User> {
        return userRepository.loginUser(username, password)
    }
}