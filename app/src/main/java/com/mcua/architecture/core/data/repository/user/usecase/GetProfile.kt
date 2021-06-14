package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.model.server.DataResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class GetProfile(private val userRepository: UserRepository) {
    suspend operator fun invoke(): DataResponse<User> {
        return userRepository.getProfile()
    }
}