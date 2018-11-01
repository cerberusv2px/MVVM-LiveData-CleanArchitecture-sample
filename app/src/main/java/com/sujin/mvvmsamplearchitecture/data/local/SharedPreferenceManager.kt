package com.sujin.mvvmsamplearchitecture.data.local

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE)

   /* var userPhone: String
        get() = sharedPreferences.getString(Constants.PREF_PHONE, "")
        set(value) = sharedPreferences.edit { putString(Constants.PREF_PHONE, value) }*/


    var accessToken: String
        get() = sharedPreferences.getString(Constants.PREF_TOKEN, "")
        set(value) = sharedPreferences.edit { putString(Constants.PREF_TOKEN, value) }

    var refreshToken: String
        get() = sharedPreferences.getString(Constants.PREF_REFRESH_TOKEN, "")
        set(value) = sharedPreferences.edit { putString(Constants.PREF_REFRESH_TOKEN, value) }

    fun clearAll() {
        /*accessToken = ""
        refreshToken = ""
        userId = -1
        distributorId = -1
        appState = 0*/
    }
}