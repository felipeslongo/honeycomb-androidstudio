package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class RunBlockingUsecases {
    fun executeUsecase1(){
        CoroutineLogger.println("Hello")

        runBlocking {
            suspendableTasks().voidTask()
        }

        CoroutineLogger.println("World!")
    }

    fun executeUsecase2() = runBlocking {
        CoroutineLogger.println("Hello")
        suspendableTasks().voidTask()
        CoroutineLogger.println("World!")
    }
}