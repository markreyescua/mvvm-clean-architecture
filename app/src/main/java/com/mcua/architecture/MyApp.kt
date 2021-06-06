package com.mcua.architecture

import android.app.Application
import com.mcua.architecture.util.AppLog

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppLog.plant(AppLog.DebugTree())
    }

}