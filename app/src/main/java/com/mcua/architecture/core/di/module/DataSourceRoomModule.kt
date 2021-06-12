package com.mcua.architecture.core.di.module

import com.mcua.architecture.core.data.db.UserDao
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoom
import dagger.Module
import dagger.Provides

@Module
class DataSourceRoomModule {

    @Provides
    fun providesUserRoomDataSource(userDao: UserDao): UserDataSourceRoom {
        return UserDataSourceRoom(userDao)
    }

}