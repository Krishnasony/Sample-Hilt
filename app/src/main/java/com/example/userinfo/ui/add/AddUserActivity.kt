package com.example.userinfo.ui.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.userinfo.R
import com.example.userinfo.room.entity.User
import com.example.userinfo.ui.detail.UserDetailActivity
import com.example.userinfo.utils.*
import com.example.userinfo.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_add_user.*

@AndroidEntryPoint
class AddUserActivity : AppCompatActivity() {

    private var mUser: User? = null
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        fullScreenView(R.color.white)
        getUserData()
        btn_user_save.setOnClickListener {
            addOrUpdateUser()
        }

        btn_back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getUserData() {
        userViewModel.user.observe(this, Observer { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    showToast("loading")
                }
                Status.SUCCESS -> {
                    resource.data?.let {
                        showToast("User: $it")
                        mUser = it
                    }
                }
                Status.ERROR -> {
                    showToast("Error")
                }
            }
        })
    }

    private fun addOrUpdateUser() {
        if (isValidEntries()) {
            mUser?.let {
                userViewModel.addUser(it)
            }
            UserDetailActivity.start(this)
            finish()
        }
    }

    private fun isValidEntries(): Boolean {
        val (validName, messageName) = ed_user_name.validateName()
        val (validEmail, messageEmail) = ed_email.validateEmail()
        val (validMobileNo, messageMobile) = ed_mobileNo.validateMobile()
        return when {
            validName.not() -> {
                showToast(messageName)
                false
            }
            validEmail.not() -> {
                showToast(messageEmail)
                false
            }
            validMobileNo.not() -> {
                showToast(messageMobile)
                false
            }
            else -> {
                mUser = User(
                    id = USER_ID, userName = messageName, mobileNo = messageMobile.toLong(),
                    email = messageEmail
                )
                true
            }
        }
    }

    companion object {
        const val USER_ID = "U001"
        fun start(context: Context) = context.startActivity(
            Intent(context, AddUserActivity::class.java)
        )
    }
}
