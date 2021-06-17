package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserRepository
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceApi
import com.mcua.architecture.core.data.repository.user.datasource.UserDataSourceRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(
        userDataSourceAPI: UserDataSourceApi,
        userDataSourceRoom: UserDataSourceRoom
    ): UserRepository {
        return UserRepository(
            userDataSourceAPI,
            userDataSourceRoom
        )
    }

}