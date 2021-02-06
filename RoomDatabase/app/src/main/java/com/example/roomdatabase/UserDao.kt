package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)  //fun insert(user: User)

    @Insert
    fun insertall(list: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM USER")
    suspend fun  getalluser ():List<User>  //fun  getalluser ():List<User>  For livedata add live data ins List<User> as Livedata<List<User>> no suspend is needed

    @Query("SELECT * FROM User WHERE age>=:age")
    fun  getuserwithage(age:Int):List<User>

}