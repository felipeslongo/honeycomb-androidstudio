package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay

/**
 * Collection with suspendable functions to be used in tests and usecases
 */
class suspendableTasks {
    suspend fun voidTask(timeMillis: Long = 100){
        CoroutineLogger.printlnStart("voidTask")
        delay(timeMillis)
        CoroutineLogger.printlnEnd("voidTask")
        return
    }

    suspend fun valueReturningTask(timeMillis: Long = 100, switchState: Boolean = false): Boolean {
        println("start valueReturningTask")
        delay(timeMillis)
        println("end valueReturningTask")
        return !switchState
    }
}