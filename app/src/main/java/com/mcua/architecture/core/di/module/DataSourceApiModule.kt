package com.mcua.architecture.core.di.module

import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.data.repository.user.datasource_impl.UserDataSourceApi
import dagger.Module
import dagger.Provides

@Module
class DataSourceApiModule {

    @Provides
    fun providesUserApiDataSource(apiService: ApiService): UserDataSourceApi {
        return UserDataSourceApi(apiService)
    }

}