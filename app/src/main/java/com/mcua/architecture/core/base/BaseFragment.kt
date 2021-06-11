package com.mcua.architecture.core.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun dismissKeyboard() {
        (activity as BaseActivity).dismissKeyboard()
    }

}