package com.example.tugasakhir.data.workManager.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.tugasakhir.data.manager.TimerManager
import com.example.tugasakhir.data.workManager.worker.TimerCompletedWorker
import com.example.tugasakhir.util.helper.MediaPlayerHelper
import com.example.tugasakhir.util.helper.TimerNotificationHelper

class TimerCompletedWorkerFactor(
    private val mediaPlayerHelper: MediaPlayerHelper,
    private val timerNotificationHelper: TimerNotificationHelper,
    private val timerManager: TimerManager,
) : ChildWorkerFactory {

    override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
        return TimerCompletedWorker(mediaPlayerHelper, timerNotificationHelper, timerManager, appContext, params)
    }
}