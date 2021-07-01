package com.gaalbaat.sensorupdatedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaalbaat.sensorupdatedapp.adapter.SensorAdapter
import com.gaalbaat.sensorupdatedapp.model.SensorModel
import com.gaalbaat.sensorupdatedapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mSensorRecyclerView: RecyclerView
    private var mSensorDataList: MutableList<SensorModel> = mutableListOf()
    private var mSensorAdapter: SensorAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        RecyclerView
        mSensorRecyclerView = findViewById(R.id.sensorRecyclerView)

        mSensorRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        mSensorAdapter = SensorAdapter(
            mSensorDataList,
            this
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
                    Log.d("TAG", "onResponse: $mResponseBody")
                } else {
                    Toast.makeText(this@MainActivity, "Data Not Found!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MutableList<SensorModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}