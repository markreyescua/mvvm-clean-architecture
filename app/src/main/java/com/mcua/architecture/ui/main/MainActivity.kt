package com.mcua.architecture.ui.main

import android.os.Bundle
import com.mcua.architecture.R
import com.mcua.architecture.core.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}