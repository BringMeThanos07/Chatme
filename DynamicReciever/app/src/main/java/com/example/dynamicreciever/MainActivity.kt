package com.example.dynamicreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val psr = PowerStateReciever()
        val ifilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }

        registerReceiver(psr,ifilter)

    }
    inner class PowerStateReciever : BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent==null) return;
            if (intent.action==Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(this@MainActivity, "connencted", Toast.LENGTH_SHORT).show()
            }
           // Toast.makeText(this@MainActivity, "power state changed", Toast.LENGTH_SHORT).show()
            if (intent.action==Intent.ACTION_POWER_DISCONNECTED)
                Toast.makeText(this@MainActivity, "disconnected", Toast.LENGTH_SHORT).show()
        }

    }
}