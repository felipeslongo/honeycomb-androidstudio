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
}