package pe.gob.msb.gp.enbici.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import pe.gob.msb.gp.enbici.data.server.*
import pe.gob.msb.gp.enbici.util.AndroidHelper
import pe.gob.msb.gp.enbici.util.PermissionHelper
import pe.gob.msb.gp.enbici.util.PermissionHelperImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun bicycleStationDbServiceProvider(): BicycleStationDbService = ApiClient.bicycleStations

    @Singleton
    @Provides
    fun fireFighterDbServiceProvider(): FireFighterDbService = ApiClient.fireFighter

    @Singleton
    @Provides
    fun huacaDbServiceProvider(): HuacaDbService = ApiClient.huaca

    @Singleton
    @Provides
    fun kallpawasiDbServiceProvider(): KallpawasiDbService = ApiClient.kallpaWasi

    @Singleton
    @Provides
    fun parkletDbServiceProvider(): ParkletDbService = ApiClient.parklet

    @Singleton
    @Provides
    fun policeStationDbServiceProvider(): PoliceStationDbService = ApiClient.policeStation

    @Singleton
    @Provides
    fun serenazgoDbServiceProvider(): SerenazgoDbService = ApiClient.serenazgo

    @Singleton
    @Provides
    fun waterFountainDbServiceProvider(): WaterFountainDbService = ApiClient.waterFountain

    @Singleton
    @Provides
    fun androidHelperProvider(@ApplicationContext context: Context): AndroidHelper =
        AndroidHelper(context)

    @Singleton
    @Provides
    fun permissionHelperProvider(): PermissionHelper = PermissionHelperImpl()
}

