package com.mcua.architecture.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.mcua.architecture.R
import com.mcua.architecture.core.base.BaseActivity

class MainActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}