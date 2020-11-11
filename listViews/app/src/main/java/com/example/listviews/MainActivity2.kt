package com.example.listviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    val array= arrayOf("arnav","yash","deepa","shreya","pooja","sanjay","arch","adi","yash","deepa","shreya","pooja","sanjay","arch","adi","yash","deepa","shreya","pooja","sanjay","arch","adi","yash","deepa","shreya","pooja","sanjay","arch","adi","yash","deepa","shreya","pooja","sanjay","arch","adi")
    val array1= arrayOf("arnav","yash","deepa","shreya","pooja","sanjay","arch","adi","yash","deepa","shreya","pooja","sanjay","arch","adi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lvNames.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,array)
        ba1.setOnClickListener {
            lvNames.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,array1)
        }

        }
    }
