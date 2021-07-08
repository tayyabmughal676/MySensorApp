package com.gaalbaat.sensorupdatedapp.`interface`

import com.gaalbaat.sensorupdatedapp.model.SensorModel

interface SensorClickedValue {
    fun onSensorValueClickListener(sensorModel: SensorModel)
}