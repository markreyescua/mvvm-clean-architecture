package com.mcua.architecture.core.di.module

import com.mcua.architecture.core.data.repository.user.UserRepository
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApi
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceRoom
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
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