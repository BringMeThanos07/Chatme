package com.example.clickablelistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_fruits_items.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listfruits.adapter=ArrayAdapter<String>(
            this,
            R.layout.list_fruits_items,
            R.id.lvfruits,
            arrayOf(
                "apple",
                "mangoes",
                "melons",
                "straws",
                "berrys",
                "bujas",
                "xyzs",
                "guavas",
                "grapes",
                "tuys",
                "papayas"
            )
        )
        listfruits.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"yash ate ${position+1} ${view.lvfruits.text}",Toast.LENGTH_SHORT).show()
        }

        btn1.setOnClickListener {
            val i =Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}