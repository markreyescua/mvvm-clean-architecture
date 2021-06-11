package com.mcua.architecture.framework.domain.user.usecase

import com.mcua.architecture.framework.data.source.UserRepository
import com.mcua.architecture.framework.model.User
import com.mcua.architecture.base.Resource

class GetUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Resource<User> {
        // do some logic here
        return userRepository.getUser(username)
    }
}