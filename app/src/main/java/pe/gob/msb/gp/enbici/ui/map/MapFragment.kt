package pe.gob.msb.gp.enbici.ui.map

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.databinding.FragmentMapBinding
import pe.gob.msb.gp.enbici.databinding.ViewProgressBarBinding
import pe.gob.msb.gp.enbici.domain.*
import pe.gob.msb.gp.enbici.ui.common.infowindow.CustomInfoWindowAdapter
import pe.gob.msb.gp.enbici.ui.common.infowindow.CustomMaker
import pe.gob.msb.gp.enbici.ui.common.infowindow.TypeMarker
import pe.gob.msb.gp.enbici.ui.common.infowindow.TypeMarker.*
import pe.gob.msb.gp.enbici.util.defaultConfig
import javax.inject.Inject

@AndroidEntryPoint
class MapFragment : Fragment(),
    MapContract.View,
    View.OnClickListener,
    GoogleMap.OnMarkerClickListener,
    OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private lateinit var loadingBinding: ViewProgressBarBinding
    private lateinit var map: GoogleMap
    private var listener: ActionListener? = null
    private var mapView: MapView? = null
    private var isRestore = false

    @Inject
    lateinit var presenter: MapContract.Presenter

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }

    interface ActionListener {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isRestore = savedInstanceState != null
    }

    override fun onClick(v: View?) {
        val id = v?.id ?: return

        when (id) {
            R.id.imageViewLocation -> {
                presenter.showMyPosition()
            }
        }
    }

    override fun showMyPosition(location: Location) {
        map.defaultConfig()

        if (!isRestore) {
            val myPosition = LatLng(location.latitude, location.longitude)
            val cameraPosition: CameraPosition = CameraPosition.Builder()
                .target(myPosition)
                .zoom(13F)
                .bearing(30f)
                .tilt(45F)
                .build()
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap ?: return
        map.setOnMarkerClickListener(this)
        presenter.loadMarkers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        binding.imageViewLocation.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null) {
            mapView?.onCreate(savedInstanceState)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        loadingBinding = ViewProgressBarBinding.bind(binding.root)
        mapView = binding.mapView
        mapView?.getMapAsync(this)
        return binding.root
    }

    private fun <T> setMapLocation(data: T, type: TypeMarker, position: LatLng, marker: Int) {

        val entity = Gson().toJson(data)
        val customMarker = CustomMaker(entity, type.name)
        val title = Gson().toJson(customMarker)

        map.addMarker(
            MarkerOptions()
                .position(position)
                .anchor(0f, 1f)
                .icon(addMaker(marker))
                .title(title)
        )
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        map.setInfoWindowAdapter(
            CustomInfoWindowAdapter(
                LayoutInflater.from(context)
            )
        )

        return false
    }

    override fun showBicycleStations(bicycleStations: List<BicycleStation>) {
        bicycleStations.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, BICYCLE_STATION, position, it.marker)
        }
    }

    override fun showFireFightersfires(fighters: List<FireFighter>) {
        fighters.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, FIREFIGHTER, position, it.marker)
        }
    }

    override fun showHuacas(huacas: List<Huaca>) {
        huacas.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, HUACA, position, it.marker)
        }
    }

    override fun showKallpaWasi(kallpaWasi: List<KallpaWasi>) {
        kallpaWasi.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, KALLPAWASI, position, it.marker)
        }
    }

    override fun showParklets(parklet: List<Parklet>) {
        parklet.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, PARKLET, position, it.marker)
        }
    }

    override fun showPoliceStations(policeStations: List<PoliceStation>) {
        policeStations.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, POLICE_STATION, position, it.marker)
        }
    }

    override fun showSerenazgos(serenazgos: List<Serenazgo>) {
        serenazgos.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, SERENAZGO, position, it.marker)
        }
    }

    override fun showWaterFountains(waterFountains: List<WaterFountain>) {
        waterFountains.forEach {
            val position = LatLng(it.latitude, it.longitude)
            setMapLocation(it, WATER_FOUNTAIN, position, it.marker)
        }
    }

    private fun addMaker(marker: Int): BitmapDescriptor {
        return BitmapDescriptorFactory.fromResource(marker)
    }

    override fun onDestroyView() {
        presenter.onDestroyScope()
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }
}