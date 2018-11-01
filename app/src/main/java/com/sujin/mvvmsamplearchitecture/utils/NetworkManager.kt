package com.sujin.mvvmsamplearchitecture.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager {

    companion object {
        fun checkNetworkAvailability(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}