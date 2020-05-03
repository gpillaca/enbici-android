package pe.gob.msb.gp.enbici.data.repository

import android.location.Location

interface LocationRepository {
    suspend fun getUserPosition(): Location?
}