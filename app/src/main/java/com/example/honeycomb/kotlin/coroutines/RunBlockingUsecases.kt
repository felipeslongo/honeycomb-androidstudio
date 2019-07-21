package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class RunBlockingUsecases {
    fun executeUsecase1(){
        println("Hello,")

        runBlocking {
            suspendableTasks().voidTask()
        }

        println("World!")
    }

    fun executeUsecase2() = runBlocking {
        println("Hello,")
        suspendableTasks().voidTask()
        println("World!")
    }
}