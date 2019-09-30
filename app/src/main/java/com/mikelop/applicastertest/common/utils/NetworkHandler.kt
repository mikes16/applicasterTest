package com.mikelop.applicastertest.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.mikelop.applicastertest.common.extensions.connectivityManager

/**
 * Injectable class which returns information about the network connection state.
 */
class NetworkHandler(private val context: Context) {
    val isConnected:Boolean get() =
    context.connectivityManager.run {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getNetworkCapabilities(activeNetwork)!!.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        } else {
            @Suppress("DEPRECATION")
            activeNetworkInfo!!.run {
                when (type) {
                    ConnectivityManager.TYPE_WIFI,
                    ConnectivityManager.TYPE_MOBILE,
                    ConnectivityManager.TYPE_ETHERNET-> true
                    else -> false
                }
            }
        }
    }
}