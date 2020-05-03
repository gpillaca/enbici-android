package pe.gob.msb.gp.enbici.ui.map

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.gob.msb.gp.enbici.data.repository.LocationRepository
import pe.gob.msb.gp.enbici.data.repository.MapRepository
import pe.gob.msb.gp.enbici.ui.common.Scope
import timber.log.Timber

class MapPresenter(
    private val mapRepository: MapRepository,
    private val locationRepository: LocationRepository
) : MapContract.Presenter,
    Scope by Scope.Impl() {

    init {
        onCreateScope()
    }

    private var view: MapContract.View? = null

    override fun attachView(view: MapContract.View) {
        this.view = view
    }

    override fun onCreateScope() {
        createScope()
    }

    override fun onDestroyScope() {
        destroyScope()
    }

    override fun loadMarkers() {
        launch {
            val position = withContext(Dispatchers.IO) {
                locationRepository.getUserPosition()
            }

            position?.let {
                view?.showMyPosition(it)
            } ?: Timber.e("Position is Null")

            val bicycleStations = async(Dispatchers.IO) {
                mapRepository.bicycleStations()
            }

            val fireFighters = async(Dispatchers.IO) {
                mapRepository.fireFighters()
            }

            val huacas = async(Dispatchers.IO) {
                mapRepository.huacas()
            }

            val kallpaWasi = async(Dispatchers.IO) {
                mapRepository.kallpawasi()
            }

            val parklets = async(Dispatchers.IO) {
                mapRepository.parklets()
            }

            val policeStations = async(Dispatchers.IO) {
                mapRepository.policeStations()
            }

            val serenazgos = async(Dispatchers.IO) {
                mapRepository.serenazgos()
            }

            val waterFountains = async(Dispatchers.IO) {
                mapRepository.waterFountains()
            }

            view?.showBicycleStations(bicycleStations.await())
            view?.showFireFightersfires(fireFighters.await())
            view?.showHuacas(huacas.await())
            view?.showKallpaWasi(kallpaWasi.await())
            view?.showParklets(parklets.await())
            view?.showPoliceStations(policeStations.await())
            view?.showSerenazgos(serenazgos.await())
            view?.showWaterFountains(waterFountains.await())
        }
    }

    override fun showMyPosition() {
        launch {
            val position = withContext(Dispatchers.IO) {
                locationRepository.getUserPosition()
            }

            position?.let {
                view?.showMyPosition(it)
            } ?: Timber.e("Position is Null")
        }
    }
}