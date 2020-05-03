package pe.gob.msb.gp.enbici.util

import com.google.android.gms.maps.model.LatLng
import java.text.DecimalFormat
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

object DistanceUtil {
    fun calculationByDistance(StartP: LatLng, EndP: LatLng): Double {
        val radius = 6371 // radio de la tierra en  kilómetros
        val lat1 = StartP.latitude
        val lat2 = EndP.latitude
        val lon1 = StartP.longitude
        val lon2 = EndP.longitude
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a =
            sin(dLat / 2) * sin(dLat / 2) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(
                dLon / 2
            ) * sin(dLon / 2)
        val c = 2 * asin(sqrt(a))
        val valueResult = radius * c
        val km = valueResult / 1
        val newFormat: DecimalFormat = DecimalFormat("####")
        var kmInDec = Integer.valueOf(newFormat.format(km))
        val meter = valueResult % 1000
        var meterInDec = Integer.valueOf(newFormat.format(meter))

        return km
    }
}