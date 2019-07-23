package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*

class CancellationAndTimeouts {
    /**
     * https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html#cancellation-and-timeouts
     */
    fun usecase01() = runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        job.join() // waits for job's completion
        println("main: Now I can quit.")
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html#cancellation-and-timeouts
     */
    fun usecase02() = runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for job's completion
        println("main: Now I can quit.")
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html#cancellation-is-cooperative
     */
    fun usecase03() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}