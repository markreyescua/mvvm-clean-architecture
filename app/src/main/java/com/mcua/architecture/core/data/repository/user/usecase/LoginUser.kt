package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.base.BaseResponse
import com.mcua.architecture.core.data.model.User
import com.mcua.architecture.core.data.repository.user.UserRepository

class LoginUser(private val userRepositoryContract: UserRepository) {
    suspend operator fun invoke(username: String, password: String): BaseResponse<User> {
        return userRepositoryContract.loginUser(username, password)
    }
}