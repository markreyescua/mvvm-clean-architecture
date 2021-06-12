package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class GetProfile(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(): Resource<User> {
        return userRepositoryContract.getProfile()
    }
}