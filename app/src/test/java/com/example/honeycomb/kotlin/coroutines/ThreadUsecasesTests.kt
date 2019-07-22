package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ThreadUsecasesTests {
    private val outputs: ArrayList<String> = ArrayList()
    private val usecases: ThreadUsecases = ThreadUsecases()

    @Before
    fun setup(){
        outputs.clear()
        val regex = Regex("[0-9]")
        SystemOutListener.instance.subscribe {
            val replaced = regex.replace(it, "#") // works
            outputs.add(replaced) }
    }

    @Test
    fun executeWithRunTest(){
        usecases.executeWithRun()

        val expectedOutputs = arrayListOf(
            "-voidTaskUsingSleep--- start: main",
            "-voidTaskUsingSleep--- ended: main",
            "-Hello---: main",
            "-World!---: main")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun executeWithStartTest(){
        usecases.executeWithStart()

        val expectedOutputs = arrayListOf(
            "-Hello---: main",
            "-voidTaskUsingSleep--- start: Thread-#",
            "-World!---: main",
            "-voidTaskUsingSleep--- ended: Thread-#")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}