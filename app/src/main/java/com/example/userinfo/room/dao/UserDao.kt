package com.example.userinfo.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.userinfo.room.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query("SELECT * FROM user WHERE id Like 'U001'")
    fun getUser(): User?
}
