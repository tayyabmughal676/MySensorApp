package com.gaalbaat.sensorupdatedapp.model

data class SensorModel(
    val created_at: String,
    val hum_sensor: Double,
    val id: Int,
    val light_sensor: Double,
    val moist_sensor: Double,
    val ph_sensor: Double,
    val temp_sensor: Double
)
