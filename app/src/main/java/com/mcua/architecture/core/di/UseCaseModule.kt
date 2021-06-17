package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserRepository
import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.data.repository.user.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
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