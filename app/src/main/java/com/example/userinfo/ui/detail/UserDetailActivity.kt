package com.example.userinfo.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.MainActivity
import com.example.userinfo.R
import com.example.userinfo.utils.fullScreenView
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        fullScreenView(R.color.colorAccent)
        btn_back.setOnClickListener {
            MainActivity.start(this)
        }

    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, UserDetailActivity::class.java)
        )
    }
}
