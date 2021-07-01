package com.gaalbaat.sensorupdatedapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gaalbaat.sensorupdatedapp.R
import com.gaalbaat.sensorupdatedapp.model.SensorModel

class SensorAdapter(
    private var mSensorDataList: MutableList<SensorModel>,
    private var mContext: Context,
) : RecyclerView.Adapter<SensorAdapter.SensorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(
            R.layout.sensor_layout,
            parent,
            false
        )
        return SensorViewHolder(mView)
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show()
        }
        holder.bindItems(mSensorDataList[position])
    }

    override fun getItemCount(): Int {
        return mSensorDataList.size
    }

    class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(sensorModel: SensorModel) {
            val mPHSensor = itemView.findViewById<TextView>(R.id.PH_Sensor_Value)
            val mHUMSensor = itemView.findViewById<TextView>(R.id.HUM_Sensor_Value)
            val mTEMPSensor = itemView.findViewById<TextView>(R.id.TEMP_Sensor_Value)
            val mLightSensor = itemView.findViewById<TextView>(R.id.LIGHT_Sensor_Value)
            val mMOISTSensor = itemView.findViewById<TextView>(R.id.MOIST_Sensor_Value)

            mPHSensor.text = sensorModel.ph_sensor.toString()
            mHUMSensor.text = sensorModel.hum_sensor.toString()
            mTEMPSensor.text = sensorModel.temp_sensor.toString()
            mLightSensor.text = sensorModel.light_sensor.toString()
            mMOISTSensor.text = sensorModel.moist_sensor.toString()
        }
    }
}