package com.mcua.architecture.core.util

import com.mcua.architecture.BuildConfig

class Constants {
    companion object {
        const val IS_PRODUCTION: Boolean = "prd" == BuildConfig.FLAVOR
    }
}