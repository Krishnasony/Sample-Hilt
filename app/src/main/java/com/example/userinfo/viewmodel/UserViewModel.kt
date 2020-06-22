package com.example.userinfo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfo.repo.UserRepository
import com.example.userinfo.room.entity.User
import com.example.userinfo.utils.Resource
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : ViewModel(){
    private val _users = MutableLiveData<Resource<User>>()
    val user: LiveData<Resource<User>>
        get() = _users

    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            userRepository.getUser()?.let {
                _users.postValue(Resource.success(it))
            }?:run{
                _users.postValue(Resource.error("Something went Wrong!", null))
            }
        }
    }

    fun addUser(user: User) = viewModelScope.launch {
        userRepository.addUser(user)
    }

}
