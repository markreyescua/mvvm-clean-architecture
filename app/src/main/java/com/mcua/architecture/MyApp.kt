package com.mcua.architecture

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.mcua.architecture.core.di.component.AppComponent
import com.mcua.architecture.core.di.component.DaggerAppComponent
import com.mcua.architecture.core.di.module.*
import com.mcua.architecture.core.util.Constants.Companion.IS_PRODUCTION
import timber.log.Timber

class MyApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: MyApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (!IS_PRODUCTION) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .databaseModule(DatabaseModule())
            .dataSourceApiModule(DataSourceApiModule())
            .dataSourceRoomModule(DataSourceRoomModule())
            .repositoryModule(RepositoryModule())
            .retrofitModule(RetrofitModule())
            .useCaseModule(UseCaseModule())
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}