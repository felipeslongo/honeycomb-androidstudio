package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test
import kotlin.collections.ArrayList

class RunBlockingUsecasesTests {
    @Test
    fun executeNestedWithoutContextRunBlockingTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeNestedWithoutContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: main @coroutine#1",
            "-voidTask--- ended: main @coroutine#1",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeInlineWithoutContextRunBlockingTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeInlineWithoutContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: main @coroutine#1",
            "-voidTask--- ended: main @coroutine#1",
            "-Hello---: main @coroutine#1",
            "-World!---: main @coroutine#1")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithCommonPoolContextRunBlockingTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeNestedWithCommonPoolContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: DefaultDispatcher-worker-1 @coroutine#1",
            "-voidTask--- ended: DefaultDispatcher-worker-1 @coroutine#1",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeInlineWithCommonPoolContextRunBlockingTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = RunBlockingUsecases()

        usecases.executeInlineWithCommonPoolContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: DefaultDispatcher-worker-1 @coroutine#1",
            "-voidTask--- ended: DefaultDispatcher-worker-1 @coroutine#1",
            "-Hello---: DefaultDispatcher-worker-1 @coroutine#1",
            "-World!---: DefaultDispatcher-worker-1 @coroutine#1")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}