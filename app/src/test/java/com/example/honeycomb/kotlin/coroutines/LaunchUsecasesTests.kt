package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import com.example.honeycomb.infrastructure.replaceDigits
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LaunchUsecasesTests{
    private val outputs = ArrayList<String>()
    private val usecases = LaunchUsecases()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it.replaceDigits("")) }
    }

    @Test
    fun executeNestedWithCommonPoolContextLaunchTest(){
        usecases.executeNestedWithCommonPoolContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main",
            "-voidTask--- start: DefaultDispatcher-worker- @coroutine#",
            "-World!---: main",
            "-voidTask--- ended: DefaultDispatcher-worker- @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithoutContextLaunchTest(){
        usecases.executeNestedWithoutContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#",
            "-voidTask--- start: main @coroutine#",
            "-World!---: main @coroutine#",
            "-voidTask--- ended: main @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithContextLaunchTest(){
        usecases.executeNestedWithContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#",
            "-World!---: main @coroutine#",
            "-voidTask--- start: main @coroutine#",
            "-voidTask--- ended: main @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithContextAndJoinLaunchTest(){
        usecases.executeNestedWithContextAndJoinLaunch()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: main @coroutine#",
            "-voidTask--- ended: main @coroutine#",
            "-Hello---: main @coroutine#",
            "-World!---: main @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithContextAndJoinLaterLaunchTest(){
        usecases.executeNestedWithContextAndJoinLaterLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#",
            "-voidTask--- start: main @coroutine#",
            "-voidTask--- ended: main @coroutine#",
            "-World!---: main @coroutine#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}