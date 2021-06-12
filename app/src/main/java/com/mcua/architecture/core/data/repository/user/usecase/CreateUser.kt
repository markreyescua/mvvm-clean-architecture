package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class CreateUser(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(user: User): BaseResponse<User> {
        return userRepositoryContract.createUser(user)
    }
}