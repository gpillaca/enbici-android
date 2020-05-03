package pe.gob.msb.gp.enbici.data.source

import android.location.Location

interface LocationDataSource {
    suspend fun findLocation(): Location
}