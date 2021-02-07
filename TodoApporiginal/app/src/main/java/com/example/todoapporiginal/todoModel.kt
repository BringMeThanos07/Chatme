package com.example.todoapporiginal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel(
    var title:String,
    var description:String,
    var category:String,
    var date: Long,
    var time:Long,
    var isfinish:Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
)