package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.core.data.repository.user.datasource.UserRepository
import com.mcua.architecture.core.data.repository.user.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesUserUseCases(
        userRepository: UserRepository
    ): UserUseCases {
        return UserUseCases(
            createUserUseCase = CreateUserUseCase(userRepository),
            deleteUserLocalUseCase = DeleteUserLocalUseCase(userRepository),
            getProfileUseCase = GetProfileUseCase(userRepository),
            getUserLocalUseCase = GetUserLocalUseCase(userRepository),
            loginUserUseCase = LoginUserUseCase(userRepository),
            saveUserLocalUseCase = SaveUserLocalUseCase(userRepository)
        )
    }

}