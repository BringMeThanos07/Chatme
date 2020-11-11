package com.example.kotlinviewbinding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
const val KEY_1="Name"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val i=Intent(this,MainActivity2::class.java)
            i.putExtra(KEY_1,"yash") //EXPLICIT INTENT
            startActivity(i)
        }
        button4.setOnClickListener {
            val email=editTextTextPersonName2.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_SENDTO
            i.data= Uri.parse("mailto:$email")
            startActivity(i)
        }
        button5.setOnClickListener {
            val address=editTextTextPersonName2.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("http://$address")
            startActivity(i)
        }
        button6.setOnClickListener {
            val tele=editTextTextPersonName2.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_DIAL
            i.data= Uri.parse("tel:$tele")
            startActivity(i)
        }

    }
}
