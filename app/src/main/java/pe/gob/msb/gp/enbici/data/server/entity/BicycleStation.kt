package pe.gob.msb.gp.enbici.data.server.entity

import com.google.gson.annotations.SerializedName

data class BicycleStation(
    @SerializedName("pues_id") val id: String,
    @SerializedName("pues_nom") val name: String,
    @SerializedName("pues_direccion") val address: String,
    @SerializedName("latitud") val latitude: String,
    @SerializedName("longitud") val longitude: String,
    @SerializedName("num") val quantity: String
)