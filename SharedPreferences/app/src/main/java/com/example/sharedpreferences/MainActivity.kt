package com.example.sharedpreferences


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spref= getPreferences(MODE_PRIVATE)
       // var editor =spref.edit()
      //  editor.putInt("COLOR", Color.RED)
       // editor.apply()

        var color=spref.getInt("COLOR",Color.WHITE)
        llBackground.setBackgroundColor(color)

        fun saveColor(color: Int){
            var editor =spref.edit()
            editor.putInt("COLOR", color)
            editor.apply()
        }

        btnBlue.setOnClickListener {
            llBackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }
        btnRed.setOnClickListener {
            llBackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }
        btnGreen.setOnClickListener {
            llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)
        }
    }
}