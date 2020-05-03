package pe.gob.msb.gp.enbici.ui.common.infowindow

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.domain.BicycleStation
import pe.gob.msb.gp.enbici.ui.common.infowindow.TypeMarker.BICYCLE_STATION
import pe.gob.msb.gp.enbici.util.fromJsonStringTo

class CustomInfoWindowAdapter(
    private var inflater: LayoutInflater
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(marker: Marker): View? {
        return null
    }

    override fun getInfoWindow(marker: Marker): View? {
        val customMarker = marker.title.fromJsonStringTo<CustomMaker>()

        return when (customMarker.type) {
            BICYCLE_STATION.name -> {
                bicycleStationWindow(customMarker.entity)
            }
            else -> {
                defaultWindow(customMarker.entity)
            }
        }
    }

    private fun bicycleStationWindow(entity: String): View {
        val view: View = inflater.inflate(R.layout.map_info_window_layout, null)

        val data = entity.fromJsonStringTo<BicycleStation>()

        view.findViewById<TextView>(R.id.textViewTitle).text = data.name
        view.findViewById<TextView>(R.id.textViewAddress).text = data.address
        view.findViewById<TextView>(R.id.textViewNumBicycles).text = data.quantity.toString()

        val distance = data.distance
        view.findViewById<TextView>(R.id.textViewDistance).text =
            String.format("%.2f", distance).plus(" Km")

        return view
    }

    private fun defaultWindow(entity: String): View {
        val view: View = inflater.inflate(R.layout.map_info_window_default_layout, null)

        val data = entity.fromJsonStringTo<InfoWindowDefault>()

        view.findViewById<TextView>(R.id.textViewTitle).text = data.name
        view.findViewById<TextView>(R.id.textViewAddress).text = data.address

        val distance = data.distance
        view.findViewById<TextView>(R.id.textViewDistance).text =
            String.format("%.2f", distance).plus(" Km")

        return view
    }
}