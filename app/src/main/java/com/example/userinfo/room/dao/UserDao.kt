package com.example.userinfo.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userinfo.room.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query("SELECT * FROM user WHERE id Like 'U001'")
    fun getUser(): User?
}
