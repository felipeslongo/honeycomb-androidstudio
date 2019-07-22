package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*
import java.lang.Exception

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

    suspend fun voidTaskWithException(timeMillis: Long = 100){
        CoroutineLogger.printlnStart("voidTaskWithException")
        delay(timeMillis)
        throw CoroutineException()
        return
    }

    suspend fun voidJobWithException(timeMillis: Long = 100) = CoroutineScope(Dispatchers.Default).launch{
        CoroutineLogger.printlnStart("voidJobWithException")
        delay(timeMillis)
        throw CoroutineException()
    }

    fun voidTaskUsingSleep(timeMillis: Long = 100){
        CoroutineLogger.printlnStart("voidTaskUsingSleep")
        Thread.sleep(timeMillis)
        CoroutineLogger.printlnEnd("voidTaskUsingSleep")
        return
    }

    suspend fun<T> asyncWithException(timeMillis: Long = 100) = CoroutineScope(Dispatchers.Default).async<T>{
        CoroutineLogger.printlnStart("defferredWithException")
        delay(timeMillis)
        throw CoroutineException()
    }


}