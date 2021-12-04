package com.example.tp_kmm.android.data.interceptor

import com.example.tp_kmm.BuildConfig
import com.example.tp_kmm.android.app.Keys.PUBLIC_KEY
import okhttp3.Interceptor
import okhttp3.Response

/*
class PublicKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()

        val newUrl = url.newBuilder().addQueryParameter("apikey", PUBLIC_KEY).build()

        return chain.proceed(request.newBuilder().url(newUrl).build())
    }
}*/