package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CancellationAndTimeoutsTests {
    private val outputs = ArrayList<String>()
    private val usecases = CancellationAndTimeouts()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it) }
    }

    @Test
    fun usecase01Test(){
        usecases.usecase01()
        val expectedOutputs = arrayListOf(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "main: Now I can quit.")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun usecase02Test(){
        usecases.usecase02()
        val expectedOutputs = arrayListOf(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "main: Now I can quit.")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun usecase03Test(){
        usecases.usecase03()
        val expectedOutputs = arrayListOf(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "job: I'm sleeping 3 ...",
            "job: I'm sleeping 4 ...",
            "main: Now I can quit.")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun usecase04MakingComputationCodeCancellableTest(){
        usecases.usecase04MakingComputationCodeCancellable()
        val expectedOutputs = arrayListOf(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "main: Now I can quit.")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}