package com.example.userinfo.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.userinfo.MainActivity
import com.example.userinfo.R
import com.example.userinfo.utils.fullScreenView
import com.example.userinfo.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user_detail.*

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        fullScreenView(R.color.colorAccent)
        btn_back.setOnClickListener {
            onBackPressed()
        }

        userViewModel.userData.observe(this, Observer { user ->
            user?.let {
                Log.d("user:", "$user")
            }
        })

    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, UserDetailActivity::class.java)
        )
    }
}
