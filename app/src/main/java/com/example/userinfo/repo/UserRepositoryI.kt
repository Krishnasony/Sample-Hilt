package com.example.userinfo.repo

import androidx.lifecycle.LiveData
import com.example.userinfo.room.entity.User

interface UserRepositoryI {

    suspend fun addUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun getUser(): LiveData<User>
}
