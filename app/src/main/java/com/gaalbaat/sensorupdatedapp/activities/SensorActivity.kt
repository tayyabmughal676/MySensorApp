package com.gaalbaat.sensorupdatedapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaalbaat.sensorupdatedapp.R
import com.gaalbaat.sensorupdatedapp.`interface`.SensorClickedValue
import com.gaalbaat.sensorupdatedapp.adapter.SensorAdapter
import com.gaalbaat.sensorupdatedapp.model.SensorModel
import com.gaalbaat.sensorupdatedapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class SensorActivity : AppCompatActivity(), SensorClickedValue {

    private lateinit var mSensorRecyclerView: RecyclerView
    private var mSensorDataList: MutableList<SensorModel> = mutableListOf()
    private var mSensorAdapter: SensorAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        //        RecyclerView
        mSensorRecyclerView = findViewById(R.id.sensorRecyclerView)

        mSensorRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        mSensorAdapter = SensorAdapter(
            mSensorDataList,
            this,
            this,
        )
        mSensorAdapter!!.notifyDataSetChanged()
        mSensorRecyclerView.adapter = mSensorAdapter

//        get Sensor Data From Server
        getSensorValueDataFromNetwork()

    }

    private fun getSensorValueDataFromNetwork() {
        ApiClient.apiService.getSensorData().enqueue(object : Callback<MutableList<SensorModel>> {
            override fun onResponse(
                call: Call<MutableList<SensorModel>>,
                response: Response<MutableList<SensorModel>>
            ) {
                val mResponseCode = response.code()
                if (mResponseCode == 200) {
                    val mResponseBody = response.body()

                    mSensorDataList.clear()

                    mResponseBody?.let {
                        mSensorDataList.addAll(it)
                    }

                    mSensorAdapter?.notifyDataSetChanged()

                    Log.d("TAG", "onResponse: $mResponseBody")
                } else {
                    Toast.makeText(this@SensorActivity, "Data Not Found!", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<MutableList<SensorModel>>, t: Throwable) {
                Toast.makeText(this@SensorActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onSensorValueClickListener(sensorModel: SensorModel) {
        Toast.makeText(
            this, "PH_Sensor ${sensorModel.ph_sensor} \n" +
                    "Hum_Sensor ${sensorModel.hum_sensor}\n" +
                    "Temp_Sensor ${sensorModel.temp_sensor}\n" +
                    "Light_Sensor ${sensorModel.light_sensor}\n" +
                    "Moist_Sensor ${sensorModel.moist_sensor}",
            Toast.LENGTH_SHORT
        ).show()

        val viewSensorValueIntent = Intent(this, ViewSensorValueActivity::class.java)
        viewSensorValueIntent.putExtra("SENSOR_VALUE", sensorModel as Serializable)
        startActivity(viewSensorValueIntent)
    }
}