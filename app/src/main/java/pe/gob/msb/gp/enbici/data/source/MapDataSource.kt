package pe.gob.msb.gp.enbici.data.source

import pe.gob.msb.gp.enbici.data.*
import pe.gob.msb.gp.enbici.data.server.*
import pe.gob.msb.gp.enbici.domain.*

class MapDataSource(
    private val fireFighterDbService: FireFighterDbService,
    private val huacaDbService: HuacaDbService,
    private val kallpawasiDbService: KallpawasiDbService,
    private val parkletDbService: ParkletDbService,
    private val policeStationDbService: PoliceStationDbService,
    private val serenazgoDbService: SerenazgoDbService,
    private val waterFountainDbService: WaterFountainDbService,
    private val bicycleStationDbService: BicycleStationDbService
) : RemoteDataSource {
    override suspend fun bicycleStations(): List<BicycleStation> {
        return bicycleStationDbService.getBicycleStations()
            .filter {
                it.longitude != null || it.longitude != null || it.name != null || it.address != null
            }
            .map {
                it.toBicycleStationDomain()
            }
    }

    override suspend fun fireFighterDbService(): List<FireFighter> {
        return fireFighterDbService.getFirefighter().map {
            it.toFireFighterDomain()
        }
    }

    override suspend fun huacaDbService(): List<Huaca> {
        return huacaDbService.getHuaca().map {
            it.toHuacaDomain()
        }
    }

    override suspend fun kallpawasiDbService(): List<KallpaWasi> {
        return kallpawasiDbService.getKallpaWasi().map {
            it.toKallpaWasiDomain()
        }
    }

    override suspend fun parkletDbService(): List<Parklet> {
        return parkletDbService.getParklet().map {
            it.toParkletDomain()
        }
    }

    override suspend fun policeStationDbService(): List<PoliceStation> {
        return policeStationDbService.getPoliceStation().map {
            it.toPoliceStationDomain()
        }
    }

    override suspend fun serenazgoDbService(): List<Serenazgo> {
        return serenazgoDbService.getSerenazgo().map {
            it.toSerenazgoDomain()
        }
    }

    override suspend fun waterFountainDbService(): List<WaterFountain> {
        return waterFountainDbService.getWaterFountain().map {
            it.toWaterFountainDomain()
        }
    }
}