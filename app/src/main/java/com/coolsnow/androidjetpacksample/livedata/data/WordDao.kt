package com.coolsnow.androidjetpacksample.livedata.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coolsnow.androidjetpacksample.livedata.data.Word
import kotlinx.coroutines.flow.Flow

/**
 *  File: WordDao
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 15:29
 *  Description:
 *
 */
@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY id DESC")
    fun getWordList(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll();
}