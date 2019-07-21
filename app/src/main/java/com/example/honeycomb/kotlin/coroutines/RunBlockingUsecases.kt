package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class RunBlockingUsecases {
    /**
     * runBlocking is a coroutine function. By not providing any context,
     * it will get run on the mainThread.
     * Hence the result as running Thread.run(). Essentially the code is run in synchronous in a
     * sequential manner. (i.e. code run per the order of the line).
     */
    fun executeNestedWithoutContextRunBlocking(){
        runBlocking {
            suspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }

    fun executeInlineWithoutContextRunBlocking() = runBlocking {
        suspendableTasks().voidTask()
        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }

    /**
     * Providing a CommonPool context to runBlocking, enable it to trigger a new thread in it’s run.
     * The interesting part of this code is, it is making the asynchronous code run in sequential
     * manner, where the original function code will only get run after runBlocking completed it’s code.
     */
    fun executeNestedWithCommonPoolContextRunBlocking(){
        runBlocking(Dispatchers.Default) {
            suspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }

    fun executeInlineWithCommonPoolContextRunBlocking() = runBlocking (Dispatchers.Default) {
        suspendableTasks().voidTask()
        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }
}