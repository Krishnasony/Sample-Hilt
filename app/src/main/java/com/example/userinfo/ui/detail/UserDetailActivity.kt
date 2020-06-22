package com.example.userinfo.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.userinfo.R
import com.example.userinfo.databinding.ActivityUserDetailBinding
import com.example.userinfo.utils.Status
import com.example.userinfo.utils.fullScreenView
import com.example.userinfo.utils.gone
import com.example.userinfo.utils.visible
import com.example.userinfo.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user_detail.*

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityUserDetailBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        fullScreenView(R.color.colorAccent)
        btn_back.setOnClickListener {
            onBackPressed()
        }

        userViewModel.user.observe(this, Observer { resource ->
            when (resource.status) {
                Status.LOADING -> progressBar.visible()
                Status.SUCCESS -> {
                    resource.data?.let {
                        dataBinding.user = it
                        progressBar.gone()
                    }
                }
                Status.ERROR -> progressBar.gone()
            }
        })

    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, UserDetailActivity::class.java)
        )
    }
}
