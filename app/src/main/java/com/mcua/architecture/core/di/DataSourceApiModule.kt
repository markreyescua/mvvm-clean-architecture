package com.mcua.architecture.core.di

import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceApiModule {

    @Singleton
    @Provides
    fun providesUserApiDataSource(apiService: ApiService): UserDataSourceApiImpl {
        return UserDataSourceApiImpl(apiService)
    }

}