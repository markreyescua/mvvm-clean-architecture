package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.repository.user.UserRepository

class GetUserLocal(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Resource<User> {
        return userRepository.getUserLocal(username)
    }
}