package pe.gob.msb.gp.enbici.domain

data class BicycleStation(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val quantity: Int,
    val distance: Double,
    val marker: Int
)