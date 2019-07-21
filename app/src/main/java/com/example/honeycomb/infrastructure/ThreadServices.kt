package com.example.honeycomb.infrastructure

import android.os.Build
import android.os.Looper

class ThreadServices {
    companion object{
        val name: String
            get() =  Thread.currentThread().name

        fun isMain(): Boolean{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return Looper.getMainLooper().isCurrentThread
            }

            return Thread.currentThread() ==  Looper.getMainLooper().thread
        }

        fun isMainNoAndroid(): Boolean{
            return Thread.currentThread().id == 1L
        }
    }
}