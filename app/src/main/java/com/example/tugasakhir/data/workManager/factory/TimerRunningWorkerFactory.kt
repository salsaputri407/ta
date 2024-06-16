package com.example.tugasakhir.data.workManager.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.tugasakhir.data.manager.TimerManager
import com.example.tugasakhir.data.workManager.worker.TimerRunningWorker
import com.example.tugasakhir.util.helper.TimerNotificationHelper

class TimerRunningWorkerFactory(
    private val timerManager: TimerManager,
    private val timerNotificationHelper: TimerNotificationHelper
) : ChildWorkerFactory {

    override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
        return TimerRunningWorker(timerManager, timerNotificationHelper, appContext, params)
    }
}