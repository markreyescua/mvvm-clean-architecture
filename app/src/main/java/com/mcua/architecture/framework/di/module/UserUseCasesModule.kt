package com.mcua.architecture.framework.di.module

import com.mcua.architecture.framework.domain.user.UseCases
import com.mcua.architecture.framework.domain.user.repository.UserRepository
import com.mcua.architecture.framework.domain.user.usecase.DeleteUser
import com.mcua.architecture.framework.domain.user.usecase.GetUser
import com.mcua.architecture.framework.domain.user.usecase.SaveUser

class UserUseCasesModule {
    fun getUseCases(repository: UserRepository) = UseCases(
        GetUser(repository),
        SaveUser(repository),
        DeleteUser(repository)
    )
}