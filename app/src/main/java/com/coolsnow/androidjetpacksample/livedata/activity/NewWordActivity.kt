package com.coolsnow.androidjetpacksample.livedata.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.coolsnow.androidjetpacksample.R
import com.coolsnow.androidjetpacksample.activity.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_new_word.*

/**
 *  File: NewWordActivity
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 16:24
 *  Description:
 *
 */
@AndroidEntryPoint
class NewWordActivity : BaseActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        button_save.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_word.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = edit_word.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}