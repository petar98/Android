package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private val mutable_score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = mutable_score
    private val mutable_eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = mutable_eventPlayAgain

    init {
        mutable_score.value = finalScore
    }

    fun onPlayAgain() {
        mutable_eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        mutable_eventPlayAgain.value = false
    }
}