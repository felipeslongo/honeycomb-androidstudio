package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class RunBlockingUsecases {
    fun executeNestedRunBlocking(){
        CoroutineLogger.println("Hello")

        runBlocking {
            suspendableTasks().voidTask()
        }

        CoroutineLogger.println("World!")
    }

    fun executeInlineRunBlocking() = runBlocking {
        CoroutineLogger.println("Hello")
        suspendableTasks().voidTask()
        CoroutineLogger.println("World!")
    }
}