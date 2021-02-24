package com.coolsnow.androidjetpacksample.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 *  File: WordRepository
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 15:54
 *  Description:
 *
 */
class WordRepository(private val wordDAO: WordDAO) {
    val allWords: Flow<List<Word>> = wordDAO.getWordList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDAO.insert(word)
    }
}