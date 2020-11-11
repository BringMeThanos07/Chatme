package com.example.listviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_fruit.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvfruit.adapter = ArrayAdapter(this,R.layout.list_item_fruit, R.id.fruitname,arrayOf("apple","mango","guava","straw","BERRY"))
        lvfruit.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Johnny ate $position ${view.fruitname.text}", Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener {
            val i=Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}