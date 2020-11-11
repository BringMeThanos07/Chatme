package com.example.permission

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
             textView.text= if (isNetworkAvailable()) "connected" else "notconnected"
        }
        button2.setOnClickListener {
            val i=Intent(this,MainActivity2::class.java)
            startActivity(i)
        }

    }
    private fun isNetworkAvailable(): Boolean {
        val cm=getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (cm is ConnectivityManager){
            val networkInfo:NetworkInfo?=cm.activeNetworkInfo
            networkInfo?.isConnected?: false
        }
        else false
    }
}
/*  button.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
NetworkInfo networkInfo=cm.getActiveNetworkInfo();
boolean isConnected=networkInfo=!null && networkInfo.isConnected();
textView.setText(isConnected ? "Connected" : "Doisconnected");
}
});
IN JAVA*/
