package com.mcua.architecture

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.mcua.architecture.core.util.Constants.Companion.IS_PRODUCTION
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        lateinit var instance: MyApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (!IS_PRODUCTION) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}