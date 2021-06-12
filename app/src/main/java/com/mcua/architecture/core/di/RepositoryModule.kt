package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserRepositoryImpl
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceAPI
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesUserRepository(
        userDataSourceAPI: UserDataSourceAPI,
        userDataSourceRoom: UserDataSourceRoom
    ): UserRepositoryImpl {
        return UserRepositoryImpl(
            userDataSourceAPI,
            userDataSourceRoom
        )
    }

}