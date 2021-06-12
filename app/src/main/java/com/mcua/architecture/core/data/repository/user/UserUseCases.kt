package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.data.repository.user.usecase.*

data class UserUseCases(
    val createUserUseCase: CreateUserUseCase,
    val deleteUserLocalUseCase: DeleteUserLocalUseCase,
    val getProfileUseCase: GetProfileUseCase,
    val getUserLocalUseCase: GetUserLocalUseCase,
    val loginUserUseCase: LoginUserUseCase,
    val saveUserLocalUseCase: SaveUserLocalUseCase
)