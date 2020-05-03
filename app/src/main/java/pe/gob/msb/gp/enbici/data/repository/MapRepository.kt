package pe.gob.msb.gp.enbici.data.repository

import pe.gob.msb.gp.enbici.domain.*

interface MapRepository {
    suspend fun bicycleStations(): List<BicycleStation>
    suspend fun fireFighters(): List<FireFighter>
    suspend fun huacas(): List<Huaca>
    suspend fun kallpawasi(): List<KallpaWasi>
    suspend fun parklets(): List<Parklet>
    suspend fun policeStations(): List<PoliceStation>
    suspend fun serenazgos(): List<Serenazgo>
    suspend fun waterFountains(): List<WaterFountain>
}