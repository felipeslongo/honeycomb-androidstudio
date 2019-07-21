package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay

/**
 * Collection with suspendable functions to be used in tests and usecases
 */
class SuspendableTasks {
    suspend fun voidTask(timeMillis: Long = 100){
        CoroutineLogger.printlnStart("voidTask")
        delay(timeMillis)
        CoroutineLogger.printlnEnd("voidTask")
        return
    }

    fun voidTaskUsingSleep(timeMillis: Long = 100){
        CoroutineLogger.printlnStart("voidTaskUsingSleep")
        Thread.sleep(timeMillis)
        CoroutineLogger.printlnEnd("voidTaskUsingSleep")
        return
    }

    suspend fun valueReturningTask(timeMillis: Long = 100, switchState: Boolean = false): Boolean {
        CoroutineLogger.printlnStart("valueReturningTask")
        delay(timeMillis)
        CoroutineLogger.printlnEnd("valueReturningTask")
        return !switchState
    }
}