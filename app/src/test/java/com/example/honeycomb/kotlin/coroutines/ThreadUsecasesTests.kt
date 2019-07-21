package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test

class ThreadUsecasesTests {
    @Test
    fun executeUsecase1Test(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = ThreadUsecases()

        usecases.executeUsecase1()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: main",
            "-voidTaskUsingSleep--- ended: main",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeUsecase2Test(){
        val outputs = ArrayList<String>()
        SystemOutListener.instance.subscribe { outputs.add(it) }
        val usecases = ThreadUsecases()

        usecases.executeUsecase2()
        Thread.sleep(100)

        val expectedOutputs = arrayListOf(
            "-Hello---: main",
            "-voidTaskUsingSleep--- start: Thread-0",
            "-World!---: main",
            "-voidTaskUsingSleep--- ended: Thread-0")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}