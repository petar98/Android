package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val mutable_word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = mutable_word
    private val mutable_score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = mutable_score
    private val mutable_eventGameFinished = MutableLiveData<Boolean>()
    val eventGameFinished: LiveData<Boolean>
        get() = mutable_eventGameFinished

    private lateinit var wordList: MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    init {
        mutable_word.value = ""
        mutable_score.value = 0

        resetList()
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            mutable_word.value = wordList.removeAt(0)
        } else {
            onGameFinished()
        }
    }

    fun onSkip() {
        mutable_score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        mutable_score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun onGameFinishComplete() {
        mutable_eventGameFinished.value = false
    }

    private fun onGameFinished() {
        mutable_eventGameFinished.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}