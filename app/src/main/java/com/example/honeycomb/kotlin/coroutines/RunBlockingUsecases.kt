package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

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
}