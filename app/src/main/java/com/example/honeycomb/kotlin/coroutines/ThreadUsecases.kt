package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.runBlocking

class ThreadUsecases {
    fun executeUsecase1(){
        Thread{
            suspendableTasks().voidTaskUsingSleep()
        }.run()

        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
    }

    fun executeUsecase2() {
        Thread{
            Thread.sleep(100)
            suspendableTasks().voidTaskUsingSleep()
        }.start()

        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
    }
}