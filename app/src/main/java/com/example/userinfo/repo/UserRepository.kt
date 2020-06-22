package com.example.userinfo.repo

import com.example.userinfo.room.dao.UserDao
import com.example.userinfo.room.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) : UserRepositoryI {
    override suspend fun addUser(user: User) = withContext(Dispatchers.IO) {
        userDao.addUser(user)
    }

    override suspend fun getUser() = withContext(Dispatchers.IO) {
        userDao.getUser()
    }
}
