package com.coolsnow.androidjetpacksample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolsnow.androidjetpacksample.R
import com.coolsnow.androidjetpacksample.data.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user.name = "abc"
        user.age = 18
        text.text = user.toString()
    }
}