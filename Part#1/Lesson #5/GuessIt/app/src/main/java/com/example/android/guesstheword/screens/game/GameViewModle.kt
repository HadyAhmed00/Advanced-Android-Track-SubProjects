package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    /** The live Data Attributes */
    // The current word
    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word
    // The current score
    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score
    private val _gameFished = MutableLiveData<Boolean>()
    val gameFinshed : LiveData<Boolean>
        get() = _gameFished

    private val _timeCounter = MutableLiveData<String>()
    val timeCounter : LiveData<String>
        get() = _timeCounter
    
    /**
     * The variables */
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME = 10000L
    }
    // The list of words - the front of the list is the next word to guess
    lateinit var wordList: MutableList<String>
    private var timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
        override fun onFinish() {

            _gameFished.value=true
        }

        override fun onTick(p0: Long) {

            _timeCounter.value= DateUtils.formatElapsedTime(p0)
        }
    }


    init {
        Log.i("GameViewModel","View Model is created")
        _score.value=0
        resetList()
        nextWord()
        timer.start()

    }
    /** filling The word and Shuffling it */
    fun resetList() {
        wordList = mutableListOf(
            "queen", "hospital", "basketball", "cat", "change","snail",
            "soup","calendar","sad","desk","guitar","home","railway",
            "zebra","jelly","car","crow","trade","bag", "roll","bubble"
        )
        wordList.shuffle()
    }
    /** Check if The list Words is empty then end the game else get next word
    form the words list **/
    fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)


    }
    /** Methods for buttons presses **/
    fun onSkip() {
        _score.value = (_score.value )?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value= (_score.value)?.plus(1)
        nextWord()
    }

    fun gameIsDone(){
        _gameFished.value=false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

}