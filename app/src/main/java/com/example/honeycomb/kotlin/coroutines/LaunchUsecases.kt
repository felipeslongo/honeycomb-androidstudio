package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*

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

    /**
     * launch is a coroutine function. By not providing any context, it will get run on a different
     * thread. Hence the result as running Thread.start(). Essentially the code is run in
     * asynchronous in a parallel order.
     */
    fun executeNestedWithoutContextLaunch() = runBlocking{
        val task = launch {
            SuspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        delay(100)
        CoroutineLogger.println("World!")
    }
}