package pe.gob.msb.gp.enbici.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import pe.gob.msb.gp.enbici.data.repository.LocationRepository
import pe.gob.msb.gp.enbici.data.repository.LocationRepositoryImpl
import pe.gob.msb.gp.enbici.data.repository.MapRepository
import pe.gob.msb.gp.enbici.data.repository.MapRepositoryImpl
import pe.gob.msb.gp.enbici.data.server.*
import pe.gob.msb.gp.enbici.data.source.*
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun mapRepositoryProvider(
        remoteDataSource: RemoteDataSource,
        persistentStorage: PersistentStorage
    ): MapRepository = MapRepositoryImpl(remoteDataSource, persistentStorage)

    @Provides
    fun mapDataSourceProvider(
        fireFighterDbService: FireFighterDbService,
        huacaDbService: HuacaDbService,
        kallpawasiDbService: KallpawasiDbService,
        parkletDbService: ParkletDbService,
        policeStationDbService: PoliceStationDbService,
        serenazgoDbService: SerenazgoDbService,
        waterFountainDbService: WaterFountainDbService,
        bicycleStationDbService: BicycleStationDbService
    ): RemoteDataSource = MapDataSource(
        fireFighterDbService,
        huacaDbService,
        kallpawasiDbService,
        parkletDbService,
        policeStationDbService,
        serenazgoDbService,
        waterFountainDbService,
        bicycleStationDbService
    )

    @Provides
    fun locationRepositoryProvider(
        locationDataSource: LocationDataSource,
        persistentStorage: PersistentStorage
    ): LocationRepository = LocationRepositoryImpl(locationDataSource, persistentStorage)

    @Singleton
    @Provides
    fun persistentStorageProvider(): PersistentStorage = InMemoryPersistentStorage()

    @Provides
    fun locationDataSourceProvider(
        @ApplicationContext context: Context
    ): LocationDataSource = PlayServiceDataSource(context)
}