package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserUseCases
import com.mcua.architecture.ui.account.features.login.LoginViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Singleton
    @Provides
    fun providesLoginViewModel(userUseCases: UserUseCases): LoginViewModelFactory {
        return LoginViewModelFactory((userUseCases))
    }

}