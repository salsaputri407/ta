package com.example.tugasakhir.util

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

fun String?.parseInt(): Int {
    return if (this.isNullOrEmpty()) 0 else this.toInt()
}

fun Class<out BroadcastReceiver>?.setIntentAction(
    actionName: String,
    requestCode: Int,
    context: Context,
): PendingIntent {
    val broadcastIntent =
        Intent(context, this).apply {
            action = actionName
        }
    return PendingIntent.getBroadcast(
        context,
        requestCode,
        broadcastIntent,
        GlobalProperties.PENDING_INTENT_FLAG,
    )
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3) -> R?): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}