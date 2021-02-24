package com.coolsnow.androidjetpacksample.livedata.data

import androidx.annotation.WorkerThread
import com.coolsnow.androidjetpacksample.livedata.data.Word
import com.coolsnow.androidjetpacksample.livedata.data.WordDao
import kotlinx.coroutines.flow.Flow

/**
 *  File: WordRepository
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 15:54
 *  Description:
 *
 */
class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getWordList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}