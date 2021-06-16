package com.mcua.architecture.core.util.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mcua.architecture.core.util.network.NetworkUtil

fun isNetworkAvailable() = NetworkUtil.isNetworkAvailable()

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

fun Fragment.showToast(msg: String, long: Boolean = true) {
    val duration = if (long) {
        Toast.LENGTH_LONG
    } else {
        Toast.LENGTH_SHORT
    }
    view?.let { makeToast(it.context, msg, duration) }
}

fun Activity.showToast(msg: String, long: Boolean = true) {
    val duration = if (long) {
        Toast.LENGTH_LONG
    } else {
        Toast.LENGTH_SHORT
    }
    makeToast(this, msg, duration)
}

fun makeToast(context: Context, msg: String, duration: Int) {
    Toast.makeText(context, msg, duration).show()
}