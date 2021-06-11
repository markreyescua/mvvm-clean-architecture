package com.mcua.architecture

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.mcua.architecture.util.Constants.Companion.IS_PRODUCTION
import timber.log.Timber

class MyApp : Application() {

    companion object {
        lateinit var instance: MyApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (!IS_PRODUCTION) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}