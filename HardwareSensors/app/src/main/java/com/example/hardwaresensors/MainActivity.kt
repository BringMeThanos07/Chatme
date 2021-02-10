package com.example.hardwaresensors

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SensorEventListener {

   // lateinit var sensorEventListener: SensorEventListener
    lateinit var sensorManager: SensorManager
    lateinit var  proxSensor: Sensor
    lateinit var accelSesor:Sensor

    val colors = arrayOf(Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,Color.YELLOW,Color.DKGRAY,Color.TRANSPARENT,Color.MAGENTA,Color.LTGRAY,Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val sensorManager: SensorManager?
        sensorManager = getSystemService<SensorManager>()!!

        /* if(sensorManager==null){
            Toast.makeText(this,"Could not get sensors",Toast.LENGTH_SHORT)
            finish()
        }else{
           val sensors = sensorManager.getSensorList(Sensor.TYPE_ALL)
            sensors.forEach {
                Log.d("HWSENS","""
                    ${it.name} | ${it.stringType} | ${it.vendor}
                """.trimIndent())
            }
        }*/
        //val proxSensor: Sensor?
        proxSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        accelSesor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        //sensorEventListener = object : SensorEventListener {

           /* override fun onSensorChanged(event: SensorEvent?) {
                Log.d("HWSENS", """
                   onSensorChanged : ${event!!.values[0]}
                """.trimIndent())
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // nothing
            }*/

       // }

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onResume() {
        sensorManager.registerListener(this,proxSensor,1000 * 1000)
        sensorManager.registerListener(this,accelSesor,1000 * 1000)
        super.onResume()
    }

    override fun onSensorChanged(event: SensorEvent?) {
       // Log.d("HWSENS", """
                //   onSensorChanged : ${event!!.values[0]}
               // """.trimIndent())
       // if (event!!.values[0]>0){
       //    flprox.setBackgroundColor(colors[Random.nextInt(10)])
        //}
        val bgcolor = Color.rgb(accel2color(event!!.values[0]),accel2color(event!!.values[1]),accel2color(event!!.values[2]))
        flaccel.setBackgroundColor(bgcolor)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //nothing
    }

    private fun accel2color(accel : Float):Int{
        return (((accel+12)/24)*255).roundToInt()
    }
}