package pe.gob.msb.gp.enbici.data.repository

import android.location.Location
import pe.gob.msb.gp.enbici.data.source.LocationDataSource
import pe.gob.msb.gp.enbici.data.source.PersistentStorage

class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource,
    private val persistentStorage: PersistentStorage
) : LocationRepository {

    override suspend fun getUserPosition(): Location? {
        val location = locationDataSource.findLocation()
        persistentStorage.saveLocation(location)
        return persistentStorage.getLocation()
    }
}