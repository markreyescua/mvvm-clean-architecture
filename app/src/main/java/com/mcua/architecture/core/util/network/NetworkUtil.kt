package com.mcua.architecture.core.util.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.TelephonyManager
import androidx.lifecycle.MutableLiveData
import com.mcua.architecture.MyApp

@Suppress("DEPRECATION")
object NetworkUtil {

    private const val NETWORK_TYPE_NONE = 0
    private const val NETWORK_TYPE_2G = 1
    private const val NETWORK_TYPE_3G = 2
    private const val NETWORK_TYPE_4G = 3
    private const val NETWORK_TYPE_5G = 4
    private const val NETWORK_TYPE_WIFI = 5

    var connectivity: MutableLiveData<Boolean> = MutableLiveData()

    fun isNetworkAvailable(): Boolean {
        return isNetworkAvailable(MyApp.instance)
    }

    fun isNetworkAvailable(context: Context): Boolean {
        return getNetworkClass(context) >= NETWORK_TYPE_3G
    }

    fun listenToNetworkAvailability(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    if (isNetworkAvailable(context) != connectivity.value) {
                        connectivity.postValue(isNetworkAvailable(context))
                    }
                }

                override fun onLost(network: Network) {
                    connectivity.postValue(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    if (isNetworkAvailable(context) != connectivity.value) {
                        connectivity.postValue(isNetworkAvailable(context))
                    }
                }

            })
        }
    }

    private fun getNetworkClass(context: Context): Int {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.activeNetworkInfo
        if (info == null || !info.isConnected) {
            // not connected
            return NETWORK_TYPE_NONE
        }
        if (info.type == ConnectivityManager.TYPE_WIFI) {
            // not to wifi
            return NETWORK_TYPE_WIFI
        }
        if (info.type == ConnectivityManager.TYPE_MOBILE) {
            return when (info.subtype) {
                // list of 2G connections
                TelephonyManager.NETWORK_TYPE_GPRS,
                TelephonyManager.NETWORK_TYPE_EDGE,
                TelephonyManager.NETWORK_TYPE_CDMA,
                TelephonyManager.NETWORK_TYPE_1xRTT,
                TelephonyManager.NETWORK_TYPE_IDEN,
                TelephonyManager.NETWORK_TYPE_GSM -> NETWORK_TYPE_2G
                // list of 3G connections
                TelephonyManager.NETWORK_TYPE_UMTS,
                TelephonyManager.NETWORK_TYPE_EVDO_0,
                TelephonyManager.NETWORK_TYPE_EVDO_A,
                TelephonyManager.NETWORK_TYPE_HSDPA,
                TelephonyManager.NETWORK_TYPE_HSUPA,
                TelephonyManager.NETWORK_TYPE_HSPA,
                TelephonyManager.NETWORK_TYPE_EVDO_B,
                TelephonyManager.NETWORK_TYPE_EHRPD,
                TelephonyManager.NETWORK_TYPE_HSPAP,
                TelephonyManager.NETWORK_TYPE_TD_SCDMA -> NETWORK_TYPE_3G
                // list of 4G connections
                TelephonyManager.NETWORK_TYPE_LTE,
                TelephonyManager.NETWORK_TYPE_IWLAN, 19 -> NETWORK_TYPE_4G
                // list of 5G connections
                TelephonyManager.NETWORK_TYPE_NR -> NETWORK_TYPE_5G
                else -> NETWORK_TYPE_NONE
            }
        }
        return NETWORK_TYPE_NONE
    }

}