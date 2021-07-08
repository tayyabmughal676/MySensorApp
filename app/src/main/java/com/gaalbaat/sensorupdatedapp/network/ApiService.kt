package com.gaalbaat.sensorupdatedapp.network

import com.gaalbaat.sensorupdatedapp.model.SensorModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("sensors")
    fun getSensorData(): Call<MutableList<SensorModel>>
}