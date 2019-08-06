package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

class Channels {

    /*
    * https://kotlinlang.org/docs/reference/coroutines/channels.html#channel-basics
    */
    fun usecase01Basics() = runBlocking {
        val channel = Channel<Int>()
        launch {
            // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
            for (x in 1..5) channel.send(x * x)
        }
        // here we print five received integers:
        repeat(5) { println(channel.receive())}
        println("Done!")
    }

    /*
    * https://kotlinlang.org/docs/reference/coroutines/channels.html#closing-and-iteration-over-channels
    */
    fun usecase02ClosingAndIterationOverChannels() = runBlocking {
        val channel = Channel<Int>()
        launch {
            for (x in 1..5) channel.send(x * x)
            channel.close() // we're done sending
        }
        // here we print received values using `for` loop (until the channel is closed)
        for (y in channel) println(y)
        println("Done!")
    }

    /*
    * https://kotlinlang.org/docs/reference/coroutines/channels.html#building-channel-producers
    */
    fun usecase03BuildingChannelProducers() = runBlocking {
        val squares = produce<Int> {
            for (x in 1..5) channel.send(x * x)
            channel.close()
        }
        squares.consumeEach {
            println(it)
        }
        println("Done!")
    }

    /*
    * https://kotlinlang.org/docs/reference/coroutines/channels.html#pipelines
    */
    fun usecase04Pipelines() = runBlocking {
        fun CoroutineScope.produceNumbers() = produce<Int> {
            var x = 1
            while (true) send(x++)// infinite stream of integers starting from 1
        }

        fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
            for (x in numbers) send(x * x)
        }

        val numbers = produceNumbers() // produces integers from 1 and on
        val squares = square(numbers) // squares integers
        for (i in 1..5) println(squares.receive()) // print first five
        println("Done!") // we are done
        coroutineContext.cancelChildren() // cancel children coroutines
    }
}