package com.example.tugasakhir.data.workManager.worker

import android.content.Context
import android.content.pm.ServiceInfo
import android.os.Build
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.example.tugasakhir.data.manager.TimerManager
import com.example.tugasakhir.util.helper.MediaPlayerHelper
import com.example.tugasakhir.util.helper.TIMER_COMPLETED_NOTIFICATION_ID
import com.example.tugasakhir.util.helper.TimerNotificationHelper
import kotlinx.coroutines.flow.collectLatest
import kotlin.coroutines.cancellation.CancellationException

class TimerCompletedWorker(
    private val mediaPlayerHelper: MediaPlayerHelper,
    private val timerNotificationHelper: TimerNotificationHelper,
    private val timerManager: TimerManager,
    ctx: Context,
    params: WorkerParameters,
) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        return try {
            mediaPlayerHelper.prepare()
            mediaPlayerHelper.start()

            val foregroundInfo = ForegroundInfo(
                TIMER_COMPLETED_NOTIFICATION_ID,
                timerNotificationHelper.showTimerCompletedNotification(),
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK else ServiceInfo.FOREGROUND_SERVICE_TYPE_NONE
            )
            setForeground(foregroundInfo)
            timerManager.timerState.collectLatest {}

            Result.success()
        } catch (e: CancellationException) {
            mediaPlayerHelper.release()
            timerNotificationHelper.removeTimerCompletedNotification()
            Result.failure()
        }
    }
}
const val TIMER_COMPLETED_TAG = "timerCompletedTag"