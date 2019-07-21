package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LaunchUsecases {
    fun executeNestedWithCommonPoolContextLaunch(){
        CoroutineScope(Dispatchers.Default).launch {
            SuspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
        Thread.sleep(200)//Ensure finished execution
    }
}