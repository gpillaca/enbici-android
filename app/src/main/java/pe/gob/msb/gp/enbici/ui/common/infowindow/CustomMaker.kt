package pe.gob.msb.gp.enbici.ui.common.infowindow

data class CustomMaker(
    val entity: String,
    val type: String
)

data class InfoWindowDefault(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val distance: Double,
    val marker: Int
)

enum class TypeMarker {
    BICYCLE_STATION,
    FIREFIGHTER,
    HUACA,
    KALLPAWASI,
    PARKLET,
    POLICE_STATION,
    SERENAZGO,
    WATER_FOUNTAIN
}