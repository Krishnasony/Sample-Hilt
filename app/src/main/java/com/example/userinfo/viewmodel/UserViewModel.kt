package com.example.userinfo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfo.repo.UserRepository
import com.example.userinfo.room.entity.User
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : ViewModel(){
    lateinit var userData:LiveData<User>
    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
           userData = userRepository.getUser()
        }
    }

}
