package com.example.userinfo.ui.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.MainActivity
import com.example.userinfo.R
import com.example.userinfo.ui.detail.UserDetailActivity
import com.example.userinfo.utils.fullScreenView
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        fullScreenView(R.color.white)

        btn_user_save.setOnClickListener {
            UserDetailActivity.start(this)
            finish()
        }

        btn_back.setOnClickListener {
           onBackPressed()
        }
    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, AddUserActivity::class.java)
        )
    }
}
