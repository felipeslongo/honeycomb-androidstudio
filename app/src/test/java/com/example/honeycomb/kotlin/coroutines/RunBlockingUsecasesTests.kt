package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test
import kotlin.collections.ArrayList

class RunBlockingUsecasesTests {
    @Test
    fun executeNestedRunBlockingTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeNestedRunBlocking()

        val expectedOutputs = arrayListOf(
            "-Hello---: main",
            "-voidTask--- start: main @coroutine#1",
            "-voidTask--- ended: main @coroutine#1",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeInlineRunBlocking(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeInlineRunBlocking()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#1",
            "-voidTask--- start: main @coroutine#1",
            "-voidTask--- ended: main @coroutine#1",
            "-World!---: main @coroutine#1")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}