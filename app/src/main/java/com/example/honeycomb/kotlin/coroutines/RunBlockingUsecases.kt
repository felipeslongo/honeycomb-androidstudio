package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class RunBlockingUsecases {
    fun printHelloWorldWithVoidTaskUsecase(){
        println("Hello,")

        runBlocking {
            suspendableTasks().voidTask()
        }

        println("World!")
    }
}