package pe.gob.msb.gp.enbici.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import pe.gob.msb.gp.enbici.data.repository.LocationRepository
import pe.gob.msb.gp.enbici.data.repository.LocationRepositoryImpl
import pe.gob.msb.gp.enbici.data.repository.MapRepository
import pe.gob.msb.gp.enbici.data.repository.MapRepositoryImpl
import pe.gob.msb.gp.enbici.data.server.ApiClient
import pe.gob.msb.gp.enbici.data.source.*
import pe.gob.msb.gp.enbici.ui.map.MapContract
import pe.gob.msb.gp.enbici.ui.map.MapPresenter
import pe.gob.msb.gp.enbici.util.AndroidHelper
import pe.gob.msb.gp.enbici.util.PermissionHelper
import pe.gob.msb.gp.enbici.util.PermissionHelperImpl

fun Application.initDI() {
    startKoin {
        androidContext(this@initDI)
        modules(appModule, dataModule)
    }
}

private val appModule = module {
    factory<PermissionHelper> { PermissionHelperImpl() }
    factory { AndroidHelper(context = get()) }
    factory<LocationDataSource> { PlayServiceDataSource(context = get()) }
    single<PersistentStorage> { InMemoryPersistentStorage() }
    factory<LocationRepository> {
        LocationRepositoryImpl(
            locationDataSource = get(),
            persistentStorage = get()
        )
    }
}

private val dataModule = module {
    factory<RemoteDataSource> {
        MapDataSource(
            ApiClient.fireFighter,
            ApiClient.huaca,
            ApiClient.kallpaWasi,
            ApiClient.parklet,
            ApiClient.policeStation,
            ApiClient.serenazgo,
            ApiClient.waterFountain,
            ApiClient.bicycleStations
        )
    }

    factory<MapRepository> {
        MapRepositoryImpl(
            remoteDataSource = get(),
            persistentStorage = get()
        )
    }

    factory<MapContract.Presenter> {
        MapPresenter(
            mapRepository = get(),
            locationRepository = get()
        )
    }
}