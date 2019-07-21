package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class RunBlockingUsecases {
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