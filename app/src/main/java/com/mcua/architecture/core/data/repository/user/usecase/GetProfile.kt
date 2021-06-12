package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class GetProfile(private val userRepository: UserRepository) {
    suspend operator fun invoke(): BaseResponse<User> {
        return userRepository.getProfile()
    }
}