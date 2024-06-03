package com.example.spinner.helper

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent <T>: MutableLiveData<T>(){
    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if(hasActiveObservers()){
            Log.e("message", "spinners keeps stopping")
        }
        super.observe(
            owner,
            Observer<T> {t ->
                if (mPending.compareAndSet(true, false)){
                    observer.onChanged(t)
                }
            }
        )
    }

    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }
    @MainThread
    fun call(){
        value=null
    }
    companion object{
        private const val TAG = "SingleLiveEvent"
    }

}