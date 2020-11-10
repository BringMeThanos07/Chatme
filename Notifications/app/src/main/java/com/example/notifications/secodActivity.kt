package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_secod.*

class secodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secod)
        val nm1 = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm1.createNotificationChannel(
                NotificationChannel("second channel",
                "default1",
                NotificationManager.IMPORTANCE_DEFAULT)
            )
        }
        btn5.setOnClickListener {
            val simpleNotification1 = NotificationCompat.Builder(this,"second channel")
                .setContentTitle("SimpleTitle")
                .setContentText("this is the sample description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm1.notify(2,simpleNotification1)
        }
        button2.setOnClickListener {
            val i =Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")

             val pi = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification = NotificationCompat.Builder(this,"second channel")
                .setContentTitle("SimpleTitle")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setContentText("this is the sample description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm1.notify(3,clickableNotification)
        }
        button3.setOnClickListener {
            val i =Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification = NotificationCompat.Builder(this,"second channel")
                .setContentTitle("SimpleTitle")
                .addAction(R.drawable.ic_launcher_foreground,"click me",pi)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setContentText("this is the sample description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm1.notify(4,clickableNotification)
        }

    }
}