package com.mcua.architecture.framework.di.module

import com.mcua.architecture.framework.domain.user.UseCases
import com.mcua.architecture.framework.data.source.UserRepository
import com.mcua.architecture.framework.domain.user.usecase.DeleteUser
import com.mcua.architecture.framework.domain.user.usecase.GetUser
import com.mcua.architecture.framework.domain.user.usecase.SaveUser

class UserUseCaseModule {
    fun getUseCases(repository: UserRepository) = UseCases(
        GetUser(repository),
        SaveUser(repository),
        DeleteUser(repository)
    )
}