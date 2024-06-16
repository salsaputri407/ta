package com.example.tugasakhir.view.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tugasakhir.data.manager.TimerManager

class TimerViewModel(private val timerManager: TimerManager) : ViewModel(), TimerActions {

    val timerState = timerManager.timerState.asLiveData()

    override fun setHour(hour: Int) {
        timerManager.setHour(hour)
    }

    override fun setMinute(minute: Int) {
        timerManager.setMinute(minute)
    }

    override fun setSecond(second: Int) {
        timerManager.setSecond(second)
    }

    override fun setCountDownTimer() {
        timerManager.setCountDownTimer()
    }

    override fun start() {
        timerManager.start()
    }

    override fun pause() {
        timerManager.pause()
    }

    override fun reset() {
        timerManager.reset()
    }
}