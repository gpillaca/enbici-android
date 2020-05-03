package pe.gob.msb.gp.enbici.data

import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.domain.WaterFountain as WaterFountainDomain
import pe.gob.msb.gp.enbici.data.server.entity.WaterFountain as WaterFountainServer
import pe.gob.msb.gp.enbici.domain.Serenazgo as SerenazgoDomain
import pe.gob.msb.gp.enbici.data.server.entity.Serenazgo as SerenazgoServer
import pe.gob.msb.gp.enbici.domain.PoliceStation as PoliceStationDomain
import pe.gob.msb.gp.enbici.data.server.entity.PoliceStation as PoliceStationServer
import pe.gob.msb.gp.enbici.domain.Parklet as ParkletDomain
import pe.gob.msb.gp.enbici.data.server.entity.Parklet as ParkletServer
import pe.gob.msb.gp.enbici.domain.KallpaWasi as KallpaWasiDomain
import pe.gob.msb.gp.enbici.data.server.entity.KallpaWasi as KallpaWasiServer
import pe.gob.msb.gp.enbici.data.server.entity.Huaca as HuacaServer
import pe.gob.msb.gp.enbici.domain.Huaca as HuacaDomain
import pe.gob.msb.gp.enbici.domain.FireFighter as FireFighterDomain
import pe.gob.msb.gp.enbici.data.server.entity.FireFighter as FireFighterServer
import pe.gob.msb.gp.enbici.domain.BicycleStation as BicycleStationDomain
import pe.gob.msb.gp.enbici.data.server.entity.BicycleStation as BicycleStationServer

private const val DEFAULT_DISTANCE = 0.0

fun BicycleStationServer.toBicycleStationDomain() = BicycleStationDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    quantity.toInt(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_bicycle
)

fun FireFighterServer.toFireFighterDomain() = FireFighterDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_fire_fighter
)

fun HuacaServer.toHuacaDomain() = HuacaDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_huaca
)

fun KallpaWasiServer.toKallpaWasiDomain() = KallpaWasiDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_kallpawasi
)

fun ParkletServer.toParkletDomain() = ParkletDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_parklet
)

fun PoliceStationServer.toPoliceStationDomain() = PoliceStationDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_police
)

fun SerenazgoServer.toSerenazgoDomain() = SerenazgoDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_serenazgo
)

fun WaterFountainServer.toWaterFountainDomain() = WaterFountainDomain(
    id,
    name,
    address,
    latitude.toDouble(),
    longitude.toDouble(),
    DEFAULT_DISTANCE,
    R.drawable.ic_marker_water_fountain
)