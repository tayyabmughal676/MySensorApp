package com.gaalbaat.sensorupdatedapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gaalbaat.sensorupdatedapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var mViewSensorValuesBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewSensorValuesBtn = findViewById(R.id.viewSensorValuesBtn)

        mViewSensorValuesBtn.setOnClickListener {
            val intentSensor = Intent(this, SensorActivity::class.java)
            startActivity(intentSensor)
        }
    }
}