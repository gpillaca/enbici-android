package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.FireFighter
import retrofit2.http.GET

interface FireFighterDbService {

    @GET("json/bomberos.json")
    suspend fun getFirefighter(): List<FireFighter>
}