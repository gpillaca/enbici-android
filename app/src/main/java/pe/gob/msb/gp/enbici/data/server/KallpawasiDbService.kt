package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.KallpaWasi
import retrofit2.http.GET

interface KallpawasiDbService {

    @GET("json/kallpawasi.json")
    suspend fun getKallpaWasi(): List<KallpaWasi>
}