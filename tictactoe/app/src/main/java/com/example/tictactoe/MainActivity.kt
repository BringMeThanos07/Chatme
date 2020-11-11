package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
const val KEY_1="player 1"
const val  KEY_2="player 2"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button11.setOnClickListener {
           val player1=editTextTextPersonName.text.toString()
            val player2=editTextTextPersonName2.text.toString()
             val intent=Intent(this,tictocgame::class.java)
            intent.putExtra(KEY_1,player1)
           intent.putExtra(KEY_2,player2)
            startActivity(intent)
        }
    }
}
