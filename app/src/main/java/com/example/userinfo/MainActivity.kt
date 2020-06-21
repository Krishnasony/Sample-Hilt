package com.example.userinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.ui.add.AddUserActivity
import com.example.userinfo.utils.fullScreenView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullScreenView(R.color.colorAccent)
        btn_user_info.setOnClickListener {
            AddUserActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, MainActivity::class.java)
        )
    }
}
