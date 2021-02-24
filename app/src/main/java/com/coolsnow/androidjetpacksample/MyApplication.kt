package com.coolsnow.androidjetpacksample

import android.app.Application
import com.coolsnow.androidjetpacksample.livedata.data.WordRepository
import com.coolsnow.androidjetpacksample.livedata.data.WordRoomDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 *  File: MyApplication
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 11:33
 *  Description:
 *
 */
@HiltAndroidApp
class MyApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}