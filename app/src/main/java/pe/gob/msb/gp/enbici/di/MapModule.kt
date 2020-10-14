package pe.gob.msb.gp.enbici.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import pe.gob.msb.gp.enbici.ui.map.MapContract
import pe.gob.msb.gp.enbici.ui.map.MapFragment
import pe.gob.msb.gp.enbici.ui.map.MapPresenter

@InstallIn(FragmentComponent::class)
@Module
abstract class MapModule {
    @Binds
    abstract fun bindFragment(mapFragment: MapFragment): MapContract.View

    @Binds
    abstract fun bindPresenter(mapPresenter: MapPresenter): MapContract.Presenter
}

@InstallIn(FragmentComponent::class)
@Module
object MapFragmentModule {

    @Provides
    fun bindFragment(fragment: Fragment): MapFragment {
        return fragment as MapFragment
    }
}