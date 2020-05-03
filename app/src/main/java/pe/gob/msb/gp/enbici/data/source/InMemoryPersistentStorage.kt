package pe.gob.msb.gp.enbici.data.source

import android.location.Location
import pe.gob.msb.gp.enbici.domain.BicycleStation

class InMemoryPersistentStorage : PersistentStorage {

    private var location: Location? = null
    private var bicycleStations: List<BicycleStation> = listOf()

    override fun saveLocation(location: Location) {
        this.location = location
    }

    override fun getLocation(): Location? = location

    override fun saveBicycleStations(bicycleStations: List<BicycleStation>) {
        this.bicycleStations = bicycleStations
    }

    override fun getBicycleStations(): List<BicycleStation> = bicycleStations
}