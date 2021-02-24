package com.coolsnow.androidjetpacksample.activity.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.coolsnow.androidjetpacksample.activity.MainActivity

/**
 *  File: BaseActivity
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 18:06
 *  Description:
 *
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this !is MainActivity) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (android.R.id.home == item.itemId) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}