package com.gaalbaat.sensorupdatedapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gaalbaat.sensorupdatedapp.R
import com.gaalbaat.sensorupdatedapp.model.SensorModel

class ViewSensorValueActivity : AppCompatActivity() {

    private var mPH_Sensor: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_sesnor_value)

        //      Get Sensor Values
        val mSensorValues: Bundle? = intent.extras
        mSensorValues?.apply {

            val sensorValue = getSerializable("SENSOR_VALUE") as SensorModel
            Toast.makeText(
                this@ViewSensorValueActivity,
                "PH_Sensor ${sensorValue.ph_sensor} \n" +
                        "Hum_Sensor ${sensorValue.hum_sensor}\n" +
                        "Temp_Sensor ${sensorValue.temp_sensor}\n" +
                        "Light_Sensor ${sensorValue.light_sensor}\n" +
                        "Moist_Sensor ${sensorValue.moist_sensor}",
                Toast.LENGTH_SHORT
            ).show()

            mPH_Sensor = sensorValue.ph_sensor
        }

    }
}