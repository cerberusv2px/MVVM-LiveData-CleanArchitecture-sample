package com.sujin.mvvmsamplearchitecture.data

import com.sujin.mvvmsamplearchitecture.BuildConfig

object Environment {

    fun getServerUrl(): String {
        return BuildConfig.SERVER_URL
    }
}