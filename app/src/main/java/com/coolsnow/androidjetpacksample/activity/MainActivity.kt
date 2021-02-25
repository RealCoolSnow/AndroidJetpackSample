package com.coolsnow.androidjetpacksample.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coolsnow.androidjetpacksample.R
import com.coolsnow.androidjetpacksample.activity.base.BaseActivity
import com.coolsnow.androidjetpacksample.livedata.LiveDataActivity
import com.coolsnow.androidjetpacksample.workmanager.WorkManagerActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_live_data.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(
            DividerItemDecoration(
                this, LinearLayoutManager.VERTICAL
            )
        )
        val sampleList: List<SampleItem> = arrayListOf(
            SampleItem(getString(R.string.live_data), LiveDataActivity::class.java.name),
            SampleItem(getString(R.string.work_manager), WorkManagerActivity::class.java.name)
        )
        recyclerview.adapter = SampleListAdapter(this, sampleList)
    }

    data class SampleItem(
        val title: String,
        val activityClass: String
    )

    class SampleListAdapter(private val context: Context, private val list: List<SampleItem>) :
        RecyclerView.Adapter<SampleListAdapter.ViewHolder>() {

        inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val textView = v as TextView
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(context).inflate(R.layout.item_sample, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val current = list[position]
            holder.textView.text = current.title
            holder.textView.setOnClickListener {
                showSample(context, current.activityClass)
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }

        private fun showSample(context: Context, className: String) {
            val intent = Intent()
            intent.setClassName(context, className)
            context.startActivity(intent)
        }
    }
}