package com.example.timer.viewModel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.helper.SingleLiveEvent
import com.example.timer.utils.Utility
import com.example.timer.utils.Utility.formatTime
import kotlinx.coroutines.handleCoroutineException

class MainViewModel : ViewModel() {
    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData(Utility.TIME_COUNTDOWN.formatTime())
    val time: LiveData<String> = _time

    private val _progress = MutableLiveData(1.00F)
    val progress: LiveData<Float> = _progress

    private val _isPlaying = MutableLiveData(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _celebrate = SingleLiveEvent<Boolean>()
    fun handleCountDownTimer(){
        if (isPlaying.value==true){
            pauseTimer()
        } else{
            startTimer()
        }
    }

    private fun startTimer() {
        _isPlaying.value = true
        countDownTimer = object : CountDownTimer(Utility.TIME_COUNTDOWN, 1000){

            override fun onTick(millisRemaining: Long) {
                val progressValue = millisRemaining.toFloat() / Utility.TIME_COUNTDOWN
                handleTimerValues(true, millisRemaining.formatTime(), progressValue)
                _celebrate.postValue(false)
            }

            override fun onFinish() {
                pauseTimer()
            }
        }.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        handleTimerValues(false, Utility.TIME_COUNTDOWN.formatTime(), 1.0F)
    }

    private fun handleTimerValues(isPlaying: Boolean, text: String, progress: Float) {
        _isPlaying.value= isPlaying
        _time.value = text
        _progress.value = progress
    }
}