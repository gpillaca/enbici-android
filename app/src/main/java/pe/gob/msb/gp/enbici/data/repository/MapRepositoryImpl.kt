package pe.gob.msb.gp.enbici.data.repository

import com.google.android.gms.maps.model.LatLng
import pe.gob.msb.gp.enbici.data.source.PersistentStorage
import pe.gob.msb.gp.enbici.data.source.RemoteDataSource
import pe.gob.msb.gp.enbici.domain.*
import pe.gob.msb.gp.enbici.util.DistanceUtil
import javax.inject.Inject

private const val DEFAULT_DISTANCE = 0.0

class MapRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val persistentStorage: PersistentStorage
) : MapRepository {

    override suspend fun bicycleStations(): List<BicycleStation> {
        if (persistentStorage.getBicycleStations().isEmpty()) {
            val bicycleStations = remoteDataSource.bicycleStations()
            persistentStorage.saveBicycleStations(bicycleStations)
        }

        return persistentStorage.getBicycleStations().map {
            val userLocation = persistentStorage.getLocation()
            val distance = if (userLocation != null) {
                DistanceUtil.calculationByDistance(
                    LatLng(userLocation.latitude, userLocation.longitude),
                    LatLng(it.latitude, it.longitude)
                )
            } else {
                DEFAULT_DISTANCE
            }
            it.copy(distance = distance)
        }
    }

    override suspend fun fireFighters(): List<FireFighter> {
        return remoteDataSource.fireFighterDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }


    override suspend fun huacas(): List<Huaca> {
        return remoteDataSource.huacaDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }

    override suspend fun kallpawasi(): List<KallpaWasi> {
        return remoteDataSource.kallpawasiDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }

    override suspend fun parklets(): List<Parklet> {
        return remoteDataSource.parkletDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }

    override suspend fun policeStations(): List<PoliceStation> {
        return remoteDataSource.policeStationDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }

    override suspend fun serenazgos(): List<Serenazgo> {
        return remoteDataSource.serenazgoDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }

    override suspend fun waterFountains(): List<WaterFountain> {
        return remoteDataSource.waterFountainDbService().map {
            val userLocation = persistentStorage.getLocation()
            val distance = DistanceUtil.calculationByDistance(
                LatLng(userLocation!!.latitude, userLocation.longitude),
                LatLng(it.latitude, it.longitude)
            )
            it.copy(distance = distance)
        }
    }
}