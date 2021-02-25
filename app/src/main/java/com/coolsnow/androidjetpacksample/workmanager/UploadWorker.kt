package com.coolsnow.androidjetpacksample.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.coolsnow.androidjetpacksample.NotificationUtil
import com.coolsnow.androidjetpacksample.R

/**
 *  File: UploadWorker
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/25 14:37
 *  Description:
 *
 */
class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    companion object {
        const val TAG: String = "UploadWorker"
    }

    override fun doWork(): Result {
        uploadLog()
        return Result.success()
    }

    private fun uploadLog() {
        Log.i(TAG, "uploadLog call")
        NotificationUtil.show(
            applicationContext,
            applicationContext.getString(R.string.work_manager),
            applicationContext.getString(R.string.work_will_executed_tip)
        )
    }
}