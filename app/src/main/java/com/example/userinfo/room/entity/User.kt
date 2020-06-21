package com.example.userinfo.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "mobileNo") var mobileNo: Long,
    @ColumnInfo(name = "email") var email: String
)
