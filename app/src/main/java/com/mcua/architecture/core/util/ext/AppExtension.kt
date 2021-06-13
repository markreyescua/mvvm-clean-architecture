package com.mcua.architecture.core.util.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.mcua.architecture.core.util.network.NetworkUtil
import timber.log.Timber

fun isNetworkAvailable() = NetworkUtil.isNetworkAvailable()

fun safeLogDebug(msg: String) = Timber.d(msg)

fun safeLogError(msg: String) = Timber.e(msg)

fun safeLogInfo(msg: String) = Timber.i(msg)

fun safeLogVerbose(msg: String) = Timber.v(msg)

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}