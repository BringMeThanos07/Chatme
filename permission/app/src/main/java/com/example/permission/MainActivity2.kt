package com.example.permission

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main2.*
import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission_group.CALL_LOG
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button3.setOnClickListener {
         val perm= ContextCompat.checkSelfPermission(this, CALL_PHONE)
            if (perm== PackageManager.PERMISSION_GRANTED) {
                callNumber()
            }
                else
            {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),121)
            }

        }

    }
    private fun callNumber()
    {
        val tele=editTextTextPersonName.text.toString()
        val i= Intent(Intent.ACTION_CALL)
        i.data= Uri.parse("tel:$tele")
        startActivity(i)
    }
}