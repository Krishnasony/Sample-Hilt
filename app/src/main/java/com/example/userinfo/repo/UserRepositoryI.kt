package com.example.userinfo.repo

import com.example.userinfo.room.entity.User

interface UserRepositoryI {

    suspend fun addUser(user: User)

    suspend fun getUser(): User?
}
