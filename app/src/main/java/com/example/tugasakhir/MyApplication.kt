package com.example.tugasakhir

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.Configuration
import com.example.tugasakhir.data.workManager.factory.WrapperWorkerFactory
import com.example.tugasakhir.di.myModule
import com.example.tugasakhir.view.timer.TimerViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(), Configuration.Provider {

    private val workerFactory: WrapperWorkerFactory by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(
                myModule
            ))
        }
    }

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()
}