package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.WaterFountain
import retrofit2.http.GET

interface WaterFountainDbService {

    @GET("json/bebederos.json")
    suspend fun getWaterFountain(): List<WaterFountain>
}