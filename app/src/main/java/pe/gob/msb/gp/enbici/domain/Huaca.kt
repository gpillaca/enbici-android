package pe.gob.msb.gp.enbici.domain

data class Huaca(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val distance: Double,
    val marker: Int
)