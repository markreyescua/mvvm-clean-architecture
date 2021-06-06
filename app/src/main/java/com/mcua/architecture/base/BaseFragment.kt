package com.mcua.architecture.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun dismissKeyboard() {
        (activity as BaseActivity).dismissKeyboard()
    }

}