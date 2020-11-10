package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first channel",
            "default",
            NotificationManager.IMPORTANCE_DEFAULT))
        }
        btn1.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this,"first channel")
                    .setContentTitle("SimpleTitle")
                    .setContentText("this is the sample description of the notification")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(1,simpleNotification)
        }
        btn2.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this,"first channel")
                    .setContentTitle("SimpleTitle")
                    .setContentText("hi i m Yash")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(1,simpleNotification)
        }
        btn3.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this,"first channel")
                    .setContentTitle("SimpleTitle")
                    .setContentText("this is a sample")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(1,simpleNotification)
        }
    }
}