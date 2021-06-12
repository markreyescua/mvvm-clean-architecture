package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class LoginUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): Resource<User> {
        return userRepository.loginUser(username, password)
    }
}