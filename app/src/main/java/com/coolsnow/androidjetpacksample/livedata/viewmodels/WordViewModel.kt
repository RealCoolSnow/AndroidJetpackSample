package com.coolsnow.androidjetpacksample.livedata.viewmodels

import androidx.lifecycle.*
import com.coolsnow.androidjetpacksample.livedata.data.Word
import com.coolsnow.androidjetpacksample.livedata.data.WordRepository
import kotlinx.coroutines.launch

/**
 *  File: WordViewModel
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 15:58
 *  Description:
 *
 */
class WordViewModel(private val repository: WordRepository) : ViewModel() {
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData();
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}