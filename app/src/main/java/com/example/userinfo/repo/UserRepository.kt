package com.example.userinfo.repo

import androidx.lifecycle.LiveData
import com.example.userinfo.room.dao.UserDao
import com.example.userinfo.room.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) : UserRepositoryI {
    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): LiveData<User> = userDao.getUser()
}
