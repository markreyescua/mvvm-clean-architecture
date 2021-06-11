package com.mcua.architecture.core.util.network

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection

class NetworkInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val userAgent = "Android"
        val original = chain.request()

        // Add headers
        val requestBuilder = original.newBuilder()
            .header("Accept", "application/json")
            .header("Conference-Agent", userAgent)
            .header("X_DEVICE_TYPE", userAgent)
            .header("X_DEVICE_VERSION", Build.VERSION.SDK_INT.toString())
            .header("X_DEVICE_MODEL", Build.MODEL)

        // todo: implement access token here
        val accessToken = "ACCESS_TOKEN"
        if (!accessToken.isNullOrBlank()) {
            requestBuilder.header("Authorization", "Bearer $accessToken")
        }

        val request = requestBuilder.build()
        var response = chain.proceed(request)
        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
            // session expired
        }
        return response
    }

}