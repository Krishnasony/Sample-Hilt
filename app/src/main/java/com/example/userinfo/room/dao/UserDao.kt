package com.example.userinfo.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.userinfo.room.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<User>
}
