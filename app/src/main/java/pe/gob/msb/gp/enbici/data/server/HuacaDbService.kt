package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.Huaca
import retrofit2.http.GET

interface HuacaDbService {

    @GET("json/huacas.json")
    suspend fun getHuaca(): List<Huaca>
}