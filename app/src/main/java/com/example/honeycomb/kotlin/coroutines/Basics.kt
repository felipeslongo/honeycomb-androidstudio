package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * https://kotlinlang.org/docs/reference/coroutines/basics.html
 */
class Basics {
    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#your-first-coroutine
     */
    fun basic01(){
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues while coroutine is delayed
        Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#bridging-blocking-and-non-blocking-worlds
     */
    fun basic02(){
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main thread continues here immediately
        runBlocking {     // but this expression blocks the main thread
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#bridging-blocking-and-non-blocking-worlds
     */
    fun basic03() = runBlocking<Unit> { // start main coroutine
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main coroutine continues here immediately
        delay(2000L)      // delaying for 2 seconds to keep JVM alive
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#waiting-for-a-job
     */
    fun basic04() = runBlocking {
        val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join() // wait until child coroutine completes
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#structured-concurrency
     */
    fun basic05() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#scope-builder
     */
    fun basic06() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch completes
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#extract-function-refactoring
     */
    fun basic07() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine in the scope of runBlocking
            doWorld()
        }
        println("Hello,")
    }

    private suspend fun doWorld() {
        delay(1000L)
        println("World!")
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#coroutines-are-light-weight
     */
    fun basic08() = runBlocking { // this: CoroutineScope
        repeat(100_000) { // launch a lot of coroutines
            launch {
                delay(1000L)
                println(".")
            }
        }
    }

    /**
     * https://kotlinlang.org/docs/reference/coroutines/basics.html#global-coroutines-are-like-daemon-threads
     */
    fun basic09() = runBlocking {
        GlobalScope.launch {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // just quit after delay
    }
}