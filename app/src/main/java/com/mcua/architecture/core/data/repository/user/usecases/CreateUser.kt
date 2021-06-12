package com.mcua.architecture.core.data.repository.user.usecases

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class CreateUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): Resource<User> {
        return userRepository.createUser(user)
    }
}