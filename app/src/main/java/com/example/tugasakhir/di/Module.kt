package com.example.tugasakhir.di

import android.content.BroadcastReceiver
import androidx.work.CoroutineWorker
import androidx.work.WorkerFactory
import com.example.tugasakhir.data.manager.TimerManager
import com.example.tugasakhir.data.manager.WorkRequestManager
import com.example.tugasakhir.data.receiver.TimerNotificationBroadcastReceiver
import com.example.tugasakhir.data.workManager.factory.ChildWorkerFactory
import com.example.tugasakhir.data.workManager.factory.TimerCompletedWorkerFactor
import com.example.tugasakhir.data.workManager.factory.TimerRunningWorkerFactory
import com.example.tugasakhir.data.workManager.factory.WrapperWorkerFactory
import com.example.tugasakhir.data.workManager.worker.TimerCompletedWorker
import com.example.tugasakhir.data.workManager.worker.TimerRunningWorker
import com.example.tugasakhir.util.helper.MediaPlayerHelper
import com.example.tugasakhir.util.helper.TimerNotificationHelper
import com.example.tugasakhir.view.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    single<TimerManager> { TimerManager(get()) }
    single<WorkRequestManager> { WorkRequestManager(get()) }
    single<TimerNotificationHelper> { TimerNotificationHelper(get()) }
    single<WorkerFactory> { WrapperWorkerFactory(get()) }
    single<BroadcastReceiver> { TimerNotificationBroadcastReceiver(get(), get(), get()) }
    single<ChildWorkerFactory> { TimerCompletedWorkerFactor(get(), get(), get()) }
    single<ChildWorkerFactory> { TimerRunningWorkerFactory(get(), get()) }
    single<MediaPlayerHelper> { MediaPlayerHelper(get()) }
    single<CoroutineWorker> { TimerCompletedWorker(get(), get(), get(), get(), get()) }
    single<CoroutineWorker> { TimerRunningWorker(get(), get(), get(), get()) }
    viewModel { TimerViewModel(get()) }
}