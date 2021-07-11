package com.gaalbaat.sensorupdatedapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.gaalbaat.sensorupdatedapp.activities.SensorActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mPumpkimBtn: Button
    private lateinit var mTindaBtn: Button
    private lateinit var mAkoraBtn: Button
    private lateinit var mViewSensorValuesBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPumpkimBtn = findViewById(R.id.pumpkimBtn)
        mTindaBtn = findViewById(R.id.tindaBtn)
        mAkoraBtn = findViewById(R.id.akoraBtn)
        mViewSensorValuesBtn = findViewById(R.id.viewSensorValuesBtn)


        mPumpkimBtn.setOnClickListener {
            pumpkimValue()
        }

        mTindaBtn.setOnClickListener {
            tindaValue()
        }

        mAkoraBtn.setOnClickListener {
            akoraValue()
        }

        mViewSensorValuesBtn.setOnClickListener {
            val intentSensor = Intent(this, SensorActivity::class.java)
            startActivity(intentSensor)
        }
    }

    private fun akoraValue() {
        Toast.makeText(this, "Akora", Toast.LENGTH_SHORT).show()
    }

    private fun tindaValue() {
        Toast.makeText(this, "Tinda", Toast.LENGTH_SHORT).show()
    }

    private fun pumpkimValue() {
        Toast.makeText(this, "Pumpkim", Toast.LENGTH_SHORT).show()
    }

}