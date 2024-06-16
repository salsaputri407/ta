package com.example.tugasakhir.data.workManager.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

class WrapperWorkerFactory(
    private val workerFactories: Map<Class<out ListenableWorker>, ChildWorkerFactory>,
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker {
        val foundEntry =
            workerFactories.entries.find {
                Class.forName(workerClassName).isAssignableFrom(it.key)
            }
        val factory = foundEntry?.value
            ?: throw IllegalArgumentException("Unknown worker class name: $workerClassName")
        return factory.create(appContext, workerParameters)
    }
}