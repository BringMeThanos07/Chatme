package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okhttpclient = OkHttpClient()

        val request = Request.Builder().url("https://api.github.com/users/yami-0812").build()

        val gson =GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        GlobalScope.launch (Dispatchers.Main){
            val response = withContext(Dispatchers.IO)
               {okhttpclient.newCall(request).execute().body?.string()
               }
            val user= gson.fromJson<User>(response,User::class.java)
           // Log.i("Networking","${response.body?.string()}")
           // val obj=JSONObject(response)
            //val image = obj.getString("avatar_url")
           // val login = obj.getString("login")
            //val name = obj.getString("name")
            textView.text=user.login
            textView2.text=user.name
            //imageView2.
            Picasso.get().load(user.avatarUrl).into(imageView2)
        }
    }
}