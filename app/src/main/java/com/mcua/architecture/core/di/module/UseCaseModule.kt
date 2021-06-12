package com.mcua.architecture.core.di.module

import com.mcua.architecture.core.data.repository.user.UserRepository
import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.data.repository.user.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesUserUseCases(
        userRepository: UserRepository
    ): UserUseCases {
        return UserUseCases(
            createUser = CreateUser(userRepository),
            deleteUserLocal = DeleteUserLocal(userRepository),
            getProfile = GetProfile(userRepository),
            getUserLocal = GetUserLocal(userRepository),
            loginUser = LoginUser(userRepository),
            saveUserLocal = SaveUserLocal(userRepository)
        )
    }

}