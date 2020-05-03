package pe.gob.msb.gp.enbici.data.server.entity

import com.google.gson.annotations.SerializedName

data class Parklet(
    @SerializedName("id")
    val id: String,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("direccion")
    val address: String,
    @SerializedName("latitud")
    val latitude: String,
    @SerializedName("longitud")
    val longitude: String
)