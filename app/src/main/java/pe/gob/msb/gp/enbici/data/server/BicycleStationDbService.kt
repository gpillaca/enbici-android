package pe.gob.msb.gp.enbici.data.server

import pe.gob.msb.gp.enbici.data.server.entity.BicycleStation
import retrofit2.http.GET

interface BicycleStationDbService {

    @GET("service_enbici/index.php/StockBicicletas")
    suspend fun getBicycleStations(): List<BicycleStation>
}