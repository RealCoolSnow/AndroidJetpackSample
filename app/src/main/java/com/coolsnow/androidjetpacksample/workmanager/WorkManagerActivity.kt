package com.coolsnow.androidjetpacksample.workmanager

import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.coolsnow.androidjetpacksample.NotificationUtil
import com.coolsnow.androidjetpacksample.R
import com.coolsnow.androidjetpacksample.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.concurrent.TimeUnit

/**
 *  File: WorkManagerActivity
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/25 14:45
 *  Description:
 *
 */
class WorkManagerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        supportActionBar?.title = getString(R.string.work_manager)
        btn_work.setOnClickListener {
            startWork()
        }
    }

    private fun startWork() {
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build()
        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)
        NotificationUtil.show(
            this,
            getString(R.string.work_manager),
            getString(R.string.work_will_executed_tip)
        )
    }
}