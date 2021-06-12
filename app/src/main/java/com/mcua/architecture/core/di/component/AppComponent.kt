package com.mcua.architecture.core.di.component

import com.mcua.architecture.MyApp
import com.mcua.architecture.core.di.module.*
import com.mcua.architecture.ui.account.features.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        DataSourceApiModule::class,
        DataSourceRoomModule::class,
        RepositoryModule::class,
        RetrofitModule::class,
        UseCaseModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(myApp: MyApp)

    fun inject(loginViewModel: LoginViewModel)

}