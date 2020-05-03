package pe.gob.msb.gp.enbici.ui.common

import okhttp3.logging.HttpLoggingInterceptor
import pe.gob.msb.gp.enbici.BuildConfig

fun loggingInterceptor(): HttpLoggingInterceptor {
    return if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    } else {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }
}