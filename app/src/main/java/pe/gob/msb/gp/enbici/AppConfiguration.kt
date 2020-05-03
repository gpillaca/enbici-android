package pe.gob.msb.gp.enbici

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import pe.gob.msb.gp.enbici.di.initDI
import pe.gob.msb.gp.enbici.util.CrashlyticsTree
import timber.log.Timber

class AppConfiguration: Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
        initTimberWithFirebaseCrashlytics()
    }

    private fun initTimberWithFirebaseCrashlytics() {
        if (BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false)
            Timber.plant(Timber.DebugTree())
        } else {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
            Timber.plant(CrashlyticsTree())
        }
    }
}