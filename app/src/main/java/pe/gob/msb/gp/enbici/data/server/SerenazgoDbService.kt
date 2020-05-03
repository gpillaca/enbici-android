package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.Serenazgo
import retrofit2.http.GET

interface SerenazgoDbService {

    @GET("json/serenazgo.json")
    suspend fun getSerenazgo(): List<Serenazgo>
}