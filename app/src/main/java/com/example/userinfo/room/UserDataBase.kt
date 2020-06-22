package com.example.userinfo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userinfo.room.dao.UserDao
import com.example.userinfo.room.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract val userDao: UserDao
}
