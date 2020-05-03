package pe.gob.msb.gp.enbici.ui.common

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import pe.gob.msb.gp.enbici.BuildConfig

fun httpClient(loggingInterceptor: Interceptor): OkHttpClient =
    OkHttpClient.Builder().also {
        if (BuildConfig.DEBUG) {
            it.addInterceptor(loggingInterceptor)
        }
    }.build()