package pe.gob.msb.gp.enbici.domain

data class Serenazgo(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val distance: Double,
    val marker: Int
)