package com.sujin.mvvmsamplearchitecture.data.remote.helper

import com.rosia.delivery.exceptions.FailedResponseException
import com.sujin.mvvmsamplearchitecture.BuildConfig
import com.sujin.mvvmsamplearchitecture.data.local.SharedPreferenceManager
import okhttp3.*
import org.json.JSONObject
import javax.inject.Inject

class RefreshTokenService @Inject constructor(var prefs: SharedPreferenceManager) {

    fun invalidateAccessToken(): String {
        val mOkHttpClient = OkHttpClient()

        val request = Request.Builder()
                .url(BuildConfig.SERVER_URL + "user/regenerate-refresh-token")
                .addHeader("refresh-token", prefs.refreshToken)
                .post(RequestBody.create(MediaType.parse("application/json"), "UTF-8"))
                .build()
        val newResponse: Response = mOkHttpClient.newCall(request).execute()
        val tokenResponse = newResponse.body()?.string()
        try {
            val responseObject = JSONObject(tokenResponse).getJSONObject("data")
            val newToken = responseObject.getString("access_token")
            prefs.accessToken = newToken
            return newToken
        } catch (e: Exception) {
            throw FailedResponseException(newResponse.code(), "Error requesting new token")
        }

    }
}