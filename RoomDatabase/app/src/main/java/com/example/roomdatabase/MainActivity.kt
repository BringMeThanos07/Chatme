package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(this,AppDatabase::class.java,"User.db")
           // .allowMainThreadQueries()
            .fallbackToDestructiveMigration()  //change the db but not good practice
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // db.userDao().getalluser()

        button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO){ db.userDao().insert(User("yash","12345","c-24",21,1)) }
           // db.userDao().insert(User("yash","12345","c-24",21,1))
    }                                                                  // for insertion coroutine is good but for fetching livedata is good
        button2.setOnClickListener {
            val list = GlobalScope.async(Dispatchers.IO) {
                db.userDao().getalluser()                          // for livedata refer to screenshot
            }//db.userDao().getalluser()
            runBlocking {    //for coroutines
                if (list.await().isNotEmpty()) {
                    with(list.await()[0]) {
                        textView.text = name
                        textView1.text = number
                        textView2.text = address
                        textView3.text = age.toString()
                    }
                }
            }
        }
        }
}