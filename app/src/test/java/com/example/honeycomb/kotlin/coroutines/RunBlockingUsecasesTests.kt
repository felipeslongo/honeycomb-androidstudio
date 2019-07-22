package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import com.example.honeycomb.infrastructure.replaceDigits
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.collections.ArrayList

class RunBlockingUsecasesTests {
    private val outputs = ArrayList<String>()
    private val usecases = RunBlockingUsecases()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it.replaceDigits("")) }
    }

    @Test
    fun executeNestedWithoutContextRunBlockingTest(){
        usecases.executeNestedWithoutContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: main @coroutine#",
            "-voidTaskUsingSleep--- ended: main @coroutine#",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeInlineWithoutContextRunBlockingTest(){
        usecases.executeInlineWithoutContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: main @coroutine#",
            "-voidTaskUsingSleep--- ended: main @coroutine#",
            "-Hello---: main @coroutine#",
            "-World!---: main @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithCommonPoolContextRunBlockingTest(){
        usecases.executeNestedWithCommonPoolContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: DefaultDispatcher-worker- @coroutine#",
            "-voidTaskUsingSleep--- ended: DefaultDispatcher-worker- @coroutine#",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeInlineWithCommonPoolContextRunBlockingTest(){
        usecases.executeInlineWithCommonPoolContextRunBlocking()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: DefaultDispatcher-worker- @coroutine#",
            "-voidTaskUsingSleep--- ended: DefaultDispatcher-worker- @coroutine#",
            "-Hello---: DefaultDispatcher-worker- @coroutine#",
            "-World!---: DefaultDispatcher-worker- @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}