package pe.gob.msb.gp.enbici.ui.map

import android.location.Location
import pe.gob.msb.gp.enbici.domain.*

interface MapContract {
    interface View {
        fun showBicycleStations(bicycleStations: List<BicycleStation>)
        fun showFireFightersfires(fighters: List<FireFighter>)
        fun showHuacas(huacas: List<Huaca>)
        fun showKallpaWasi(kallpaWasi: List<KallpaWasi>)
        fun showParklets(parklet: List<Parklet>)
        fun showPoliceStations(policeStations: List<PoliceStation>)
        fun showSerenazgos(serenazgos: List<Serenazgo>)
        fun showWaterFountains(waterFountains: List<WaterFountain>)
        fun showMyPosition(location: Location)
    }

    interface Presenter {
        fun loadMarkers()
        fun showMyPosition()
        fun attachView(view: View)
        fun onCreateScope()
        fun onDestroyScope()
    }
}