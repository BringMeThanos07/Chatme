package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class LocaleChangedreciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
       Log.d("rcv","LOCALE")
        Toast.makeText(context, "Language changed", Toast.LENGTH_SHORT).show()
        context.startActivity(Intent(context,MainActivity::class.java))
    }
}