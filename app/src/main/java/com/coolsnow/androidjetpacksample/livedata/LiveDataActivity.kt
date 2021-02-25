package com.coolsnow.androidjetpacksample.livedata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolsnow.androidjetpacksample.MyApplication
import com.coolsnow.androidjetpacksample.R
import com.coolsnow.androidjetpacksample.activity.base.BaseActivity
import com.coolsnow.androidjetpacksample.livedata.adapter.WordListAdapter
import com.coolsnow.androidjetpacksample.livedata.data.Word
import com.coolsnow.androidjetpacksample.livedata.viewmodels.WordViewModel
import com.coolsnow.androidjetpacksample.livedata.viewmodels.WordViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_live_data.*

/**
 *  File: LiveDataActivity
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 16:44
 *  Description:
 *
 */
@AndroidEntryPoint
class LiveDataActivity : BaseActivity() {
    private val newWordActivityRequestCode = 1
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        supportActionBar?.title = getString(R.string.live_data)
        val adapter = WordListAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        fab.setOnClickListener {
            val intent = Intent(this, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.submitList(it) }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(0, it)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}