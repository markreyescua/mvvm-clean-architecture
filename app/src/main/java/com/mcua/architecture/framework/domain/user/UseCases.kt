package com.mcua.architecture.framework.domain.user

import com.mcua.architecture.framework.domain.user.usecase.DeleteUser
import com.mcua.architecture.framework.domain.user.usecase.GetUser
import com.mcua.architecture.framework.domain.user.usecase.SaveUser

data class UseCases(
    val getUser: GetUser,
    val saveUser: SaveUser,
    val deleteUser: DeleteUser,
)