package com.gaalbaat.sensorupdatedapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.gaalbaat.sensorupdatedapp.R
import com.gaalbaat.sensorupdatedapp.model.SensorModel

class ViewSensorValueActivity : AppCompatActivity() {

    private var mPHSensor: Double = 0.0
    private var mLightSensor: Double = 0.0
    private var mMoistSensor: Double = 0.0
    private var mHumSensor: Double = 0.0
    private var mTempSensor: Double = 0.0

    private lateinit var mTempSensorViewValue: TextView
    private lateinit var mLightSensorViewValue: TextView
    private lateinit var mMoistSensorViewValue: TextView
    private lateinit var mHumSensorViewValue: TextView
    private lateinit var mPHSensorViewValue: TextView

    private lateinit var mPumpkimBtn: Button
    private lateinit var mTindaBtn: Button
    private lateinit var mAkoraBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_sesnor_value)

        mPumpkimBtn = findViewById(R.id.pumpkimBtn)
        mTindaBtn = findViewById(R.id.tindaBtn)
        mAkoraBtn = findViewById(R.id.akoraBtn)

        mTempSensorViewValue = findViewById(R.id.TEMP_Sensor_Value)
        mLightSensorViewValue = findViewById(R.id.LIGHT_Sensor_Value)
        mMoistSensorViewValue = findViewById(R.id.MOIST_Sensor_Value)
        mHumSensorViewValue = findViewById(R.id.HUM_Sensor_Value)
        mPHSensorViewValue = findViewById(R.id.PH_Sensor_Value)


        //      Get Sensor Values
        val mSensorValues: Bundle? = intent.extras
        mSensorValues?.apply {
            val sensorValue = getSerializable("SENSOR_VALUE") as SensorModel
//            Toast.makeText(
//                this@ViewSensorValueActivity,
//                "PH_Sensor ${sensorValue.ph_sensor} \n" +
//                        "Hum_Sensor ${sensorValue.hum_sensor}\n" +
//                        "Temp_Sensor ${sensorValue.temp_sensor}\n" +
//                        "Light_Sensor ${sensorValue.light_sensor}\n" +
//                        "Moist_Sensor ${sensorValue.moist_sensor}",
//                Toast.LENGTH_SHORT
//            ).show()

            mPHSensor = sensorValue.ph_sensor
            mLightSensor = sensorValue.light_sensor
            mMoistSensor = sensorValue.moist_sensor
            mTempSensor = sensorValue.temp_sensor
            mHumSensor = sensorValue.hum_sensor
        }

        mPumpkimBtn.setOnClickListener {
            pumpkimValue()
        }

        mTindaBtn.setOnClickListener {
            tindaValue()
        }

        mAkoraBtn.setOnClickListener {
            akoraValue()
        }
    }

    private fun akoraValue() {
        if (mTempSensor > 32.78) {
//            Toast.makeText(this, "Temp Sensor is Bad -> $mTempSensor", Toast.LENGTH_SHORT).show()
            mTempSensorViewValue.text = "Temp Sensor is Bad"
        } else {
            mTempSensorViewValue.text = "Temp Sensor isn't matched"
        }

        if (mHumSensor == 50.85) {
//            Toast.makeText(this, "Hum Sensor is Good -> $mHumSensor", Toast.LENGTH_SHORT).show()
            mHumSensorViewValue.text = "Hum Sensor is Good"

        } else {
            mHumSensorViewValue.text = "Hum Sensor isn't matched"
        }

        if (mPHSensor < 3.337) {
//            Toast.makeText(this, "PH_Sensor is High $mPHSensor", Toast.LENGTH_SHORT).show()
            mPHSensorViewValue.text = "PH Sensor is High"

        } else {
            mPHSensorViewValue.text = "PH Sensor isn't matched"
        }

        if (mMoistSensor > 14.8) {
//            Toast.makeText(this, "Moist Sensor is Bad -> $mMoistSensor", Toast.LENGTH_SHORT).show()
            mMoistSensorViewValue.text = "Moist Sensor is Very Bad"

        } else {
            mMoistSensorViewValue.text = "Moist Sensor isn't matched"
        }

//        MaterialAlertDialogBuilder(this)
//            .setTitle("Result")
//            .setMessage("")
//            .setPositiveButton("Close") { _, _ ->
//
//            }
//            .show()
    }

    private fun tindaValue() {
        Toast.makeText(this, "Under working", Toast.LENGTH_SHORT).show()
    }


    private fun pumpkimValue() {

        if (mTempSensor > 36.5) {
//            Toast.makeText(this, "Temp Sensor is Bad -> $mTempSensor", Toast.LENGTH_SHORT).show()
            mTempSensorViewValue.text = "Temp Sensor is Bad"
        } else {
            mTempSensorViewValue.text = "Temp Sensor isn't matched"
        }

        if (mHumSensor == 47.55) {
//            Toast.makeText(this, "Hum Sensor is Good -> $mHumSensor", Toast.LENGTH_SHORT).show()
            mHumSensorViewValue.text = "Hum Sensor is Good"

        } else {
            mHumSensorViewValue.text = "Hum Sensor isn't matched"
        }

        if (mPHSensor < 8.1) {
//            Toast.makeText(this, "PH_Sensor is High $mPHSensor", Toast.LENGTH_SHORT).show()
            mPHSensorViewValue.text = "PH Sensor is High"

        } else {
            mPHSensorViewValue.text = "PH Sensor isn't matched"
        }

        if (mMoistSensor > 61.19) {
//            Toast.makeText(this, "Moist Sensor is Bad -> $mMoistSensor", Toast.LENGTH_SHORT).show()
            mMoistSensorViewValue.text = "Moist Sensor is Bad"

        } else {
            mMoistSensorViewValue.text = "Moist Sensor isn't matched"
        }

//        MaterialAlertDialogBuilder(this)
//            .setTitle("Result")
//            .setMessage("")
//            .setPositiveButton("Close") { _, _ ->
//
//            }
//            .show()
    }
}