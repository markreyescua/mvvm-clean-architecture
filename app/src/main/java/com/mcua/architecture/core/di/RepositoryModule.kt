package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.repository.user.UserRepository
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApiImpl
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoomImpl
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
        userDataSourceAPIImpl: UserDataSourceApiImpl,
        userDataSourceRoomImpl: UserDataSourceRoomImpl
    ): UserRepository {
        return UserRepository(
            userDataSourceAPIImpl,
            userDataSourceRoomImpl
        )
    }

}