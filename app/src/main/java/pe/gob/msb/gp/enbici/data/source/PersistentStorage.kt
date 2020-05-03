package pe.gob.msb.gp.enbici.data.source

import android.location.Location
import pe.gob.msb.gp.enbici.domain.BicycleStation

interface PersistentStorage {
    fun saveLocation(location: Location)
    fun getLocation(): Location?
    fun saveBicycleStations(bicycleStations: List<BicycleStation>)
    fun getBicycleStations(): List<BicycleStation>
}