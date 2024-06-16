package com.example.tugasakhir.util

import android.app.PendingIntent

object GlobalProperties {
    const val TIME_FORMAT = "%02d:%02d:%02d"
    const val PENDING_INTENT_FLAG = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
}