package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.db.UserDao
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoomImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun providesUserRoomDataSource(userDao: UserDao): UserDataSourceRoomImpl {
        return UserDataSourceRoomImpl(userDao)
    }

}