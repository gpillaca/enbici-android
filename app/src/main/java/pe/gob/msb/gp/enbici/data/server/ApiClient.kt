package pe.gob.msb.gp.enbici.data.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val bicycleStations: BicycleStationDbService by lazy { retrofit.create(BicycleStationDbService::class.java) }
    val fireFighter: FireFighterDbService by lazy { retrofit.create(FireFighterDbService::class.java) }
    val huaca: HuacaDbService by lazy { retrofit.create(HuacaDbService::class.java) }
    val kallpaWasi: KallpawasiDbService by lazy { retrofit.create(KallpawasiDbService::class.java) }
    val parklet: ParkletDbService by lazy { retrofit.create(ParkletDbService::class.java) }
    val policeStation: PoliceStationDbService by lazy { retrofit.create(PoliceStationDbService::class.java) }
    val serenazgo: SerenazgoDbService by lazy { retrofit.create(SerenazgoDbService::class.java) }
    val waterFountain: WaterFountainDbService by lazy { retrofit.create(WaterFountainDbService::class.java) }
}