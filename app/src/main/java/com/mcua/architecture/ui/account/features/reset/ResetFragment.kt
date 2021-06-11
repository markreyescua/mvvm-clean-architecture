package com.mcua.architecture.ui.account.features.reset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcua.architecture.R
import com.mcua.architecture.core.base.BaseFragment

class ResetFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reset, container, false)
    }

}