package com.sujin.mvvmsamplearchitecture.data.remote.helper

import android.content.Context
import com.rosia.delivery.exceptions.NetworkNotAvailableException
import com.sujin.mvvmsamplearchitecture.data.local.SharedPreferenceManager
import com.sujin.mvvmsamplearchitecture.data.remote.Constants.TOKEN_EXPIRED
import com.sujin.mvvmsamplearchitecture.utils.NetworkManager
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject


// TODO("Handle 403 Error")

class ApiInterceptor @Inject constructor(
    val context: Context,
    private val prefs: SharedPreferenceManager,
    private val refreshTokenService: RefreshTokenService
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!NetworkManager.checkNetworkAvailability(context)) {
            throw NetworkNotAvailableException()
        }

        synchronized(this) {
            val requestBuilder = chain?.request()?.newBuilder()

            if (!prefs.accessToken.isEmpty()) {
                requestBuilder?.addHeader("Authorization", prefs.accessToken)
            }
            val response = chain?.proceed(requestBuilder?.build())
            val responseBody = response?.body()
            val responseString = responseBody?.string()

            return if (prefs.accessToken.isNotEmpty() && response?.code() == TOKEN_EXPIRED) {
                val newToken = refreshTokenService.invalidateAccessToken()
                requestBuilder?.removeHeader("Authorization")
                requestBuilder?.addHeader("Authorization", newToken)
                chain.proceed(requestBuilder?.build())
            } else {
                val contentType = responseBody?.contentType()
                response?.newBuilder()?.body(ResponseBody.create(contentType, responseString!!))!!.build()
            }
        }
    }


}