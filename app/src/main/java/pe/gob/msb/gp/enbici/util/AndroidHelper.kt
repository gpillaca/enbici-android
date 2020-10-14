package pe.gob.msb.gp.enbici.util

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class AndroidHelper @Inject constructor(private val context: Context) {

    fun isNetWorkActive(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.isDefaultNetworkActive
    }

    fun getString(value: Int): String {
        return context.getString(value)
    }
}