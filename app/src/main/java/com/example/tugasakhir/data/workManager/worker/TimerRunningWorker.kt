package com.example.tugasakhir.data.workManager.worker

import android.content.Context
import android.content.pm.ServiceInfo
import android.os.Build
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.example.tugasakhir.data.manager.TimerManager
import com.example.tugasakhir.util.helper.TIMER_RUNNING_NOTIFICATION_ID
import com.example.tugasakhir.util.helper.TimerNotificationHelper
import kotlinx.coroutines.flow.collectLatest
import kotlin.coroutines.cancellation.CancellationException

class TimerRunningWorker(
    private val timerManager: TimerManager,
    private val timerNotificationHelper: TimerNotificationHelper,
    ctx: Context,
    params: WorkerParameters,
) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        return try {
            val foregroundInfo = ForegroundInfo(
                TIMER_RUNNING_NOTIFICATION_ID,
                timerNotificationHelper.getTimerBaseNotification().build(),
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK else ServiceInfo.FOREGROUND_SERVICE_TYPE_NONE
            )

            setForeground(foregroundInfo)

            timerManager.timerState.collectLatest {
                if (!it.isDone) {
                    timerNotificationHelper.updateTimerServiceNotification(
                        isPlaying = it.isPlaying,
                        timeText = it.timeText,
                    )
                }
            }

            Result.success()
        } catch (e: CancellationException) {
            timerNotificationHelper.removeTimerRunningNotification()
            Result.failure()
        }
    }
}
const val TIMER_RUNNING_TAG = "timerRunningTag"