package com.coolsnow.androidjetpacksample.livedata.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  File: Word
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 15:24
 *  Description:
 *
 */
@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "word") val word: String
)