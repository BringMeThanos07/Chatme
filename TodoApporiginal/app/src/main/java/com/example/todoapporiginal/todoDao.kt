package com.example.todoapporiginal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TodoDao{
    @Insert()
    suspend fun insertTask(todoModel: TodoModel):Long

    @Query("SELECT * FROM TodoModel WHERE isfinish==0")
    fun getTask(): LiveData<List<TodoModel>>

    @Query("UPDATE TodoModel SET isfinish = 1 WHERE id=:uid")
    fun finishTask(uid:Long)

    @Query("DELETE FROM TodoModel WHERE id=:uid")
    fun DeleteTask(uid:Long)
}