package com.mcua.architecture.core.data.repository.user.usecase

import com.mcua.architecture.core.data.repository.user.datasource.UserRepository

class DeleteUserLocalUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String) {
        return userRepository.deleteUserLocal(username)
    }
}