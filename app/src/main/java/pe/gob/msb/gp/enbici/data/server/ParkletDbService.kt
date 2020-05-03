package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.Parklet
import retrofit2.http.GET

interface ParkletDbService {

    @GET("json/parklet.json")
    suspend fun getParklet(): List<Parklet>
}