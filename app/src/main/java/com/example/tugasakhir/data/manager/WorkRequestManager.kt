package com.example.tugasakhir.data.manager

import android.content.Context
import androidx.work.Data
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class WorkRequestManager(val applicationContext: Context) {
    inline fun <reified T : ListenableWorker> enqueueWorker(tag: String, inputData: Data? = null) {
        val workRequest = OneTimeWorkRequestBuilder<T>().addTag(tag)

        inputData?.let {
            workRequest.setInputData(it)
        }

        WorkManager.getInstance(applicationContext).enqueue(workRequest.build())
    }

    fun cancelWorker(tag: String) {
        WorkManager.getInstance(applicationContext).cancelAllWorkByTag(tag)
    }
}