package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.PoliceStation
import retrofit2.http.GET

interface PoliceStationDbService {

    @GET("json/comisarias.json")
    suspend fun getPoliceStation(): List<PoliceStation>
}