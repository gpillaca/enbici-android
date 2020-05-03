package pe.gob.msb.gp.enbici.data.source

import pe.gob.msb.gp.enbici.domain.*

interface RemoteDataSource {
    suspend fun bicycleStations(): List<BicycleStation>
    suspend fun fireFighterDbService(): List<FireFighter>
    suspend fun huacaDbService(): List<Huaca>
    suspend fun kallpawasiDbService(): List<KallpaWasi>
    suspend fun parkletDbService(): List<Parklet>
    suspend fun policeStationDbService(): List<PoliceStation>
    suspend fun serenazgoDbService(): List<Serenazgo>
    suspend fun waterFountainDbService(): List<WaterFountain>
}