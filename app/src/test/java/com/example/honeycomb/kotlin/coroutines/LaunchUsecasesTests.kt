package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test

class LaunchUsecasesTests{
    @Test
    fun executeNestedWithCommonPoolContextLaunchTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = LaunchUsecases()

        usecases.executeNestedWithCommonPoolContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main",
            "-voidTask--- start: DefaultDispatcher-worker-1 @coroutine#1",
            "-World!---: main",
            "-voidTask--- ended: DefaultDispatcher-worker-1 @coroutine#1")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithoutContextLaunchTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = LaunchUsecases()

        usecases.executeNestedWithoutContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#1",
            "-voidTask--- start: main @coroutine#2",
            "-World!---: main @coroutine#1",
            "-voidTask--- ended: main @coroutine#2")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithContextLaunchTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = LaunchUsecases()

        usecases.executeNestedWithContextLaunch()

        val expectedOutputs = arrayListOf(
            "-Hello---: main @coroutine#1",
            "-World!---: main @coroutine#1",
            "-voidTask--- start: main @coroutine#2",
            "-voidTask--- ended: main @coroutine#2")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeNestedWithContextAndJoinLaunchTest(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = LaunchUsecases()

        usecases.executeNestedWithContextAndJoinLaunch()

        val expectedOutputs = arrayListOf(
            "-voidTask--- start: main @coroutine#2",
            "-voidTask--- ended: main @coroutine#2",
            "-Hello---: main @coroutine#1",
            "-World!---: main @coroutine#1")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}