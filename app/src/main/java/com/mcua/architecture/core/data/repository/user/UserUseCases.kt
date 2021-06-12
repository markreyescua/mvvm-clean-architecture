package com.mcua.architecture.core.data.repository.user

import com.mcua.architecture.core.data.repository.user.usecase.*

data class UserUseCases(
    val createUser: CreateUser,
    val deleteUserLocal: DeleteUserLocal,
    val getProfile: GetProfile,
    val getUserLocal: GetUserLocal,
    val loginUser: LoginUser,
    val saveUserLocal: SaveUserLocal
)