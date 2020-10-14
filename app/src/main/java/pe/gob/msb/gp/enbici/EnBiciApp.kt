package pe.gob.msb.gp.enbici

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.HiltAndroidApp
import pe.gob.msb.gp.enbici.util.CrashlyticsTree
import timber.log.Timber

@HiltAndroidApp
class EnBiciApp: Application() {

    override fun onCreate() {
        super.onCreate()
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