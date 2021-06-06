package com.mcua.architecture

import android.app.Application
import com.mcua.architecture.util.AppLog
import com.mcua.architecture.util.Constants.Companion.IS_PRODUCTION

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!IS_PRODUCTION) {
            AppLog.plant(AppLog.DebugTree())
        }
    }

}