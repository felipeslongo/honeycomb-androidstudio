package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BasicsTests {
    private val outputs = ArrayList<String>()
    private val usecases = Basics()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it) }
    }

    @Test
    fun basic01Test(){
        usecases.basic01()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic02Test(){
        usecases.basic02()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic03Test(){
        usecases.basic03()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic04Test(){
        usecases.basic04()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic05Test(){
        usecases.basic05()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic06Test(){
        usecases.basic06()
        val expectedOutputs = arrayListOf(
            "Task from coroutine scope",
            "Task from runBlocking",
            "Task from nested launch",
            "Coroutine scope is over")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic07Test(){
        usecases.basic07()
        val expectedOutputs = arrayListOf(
            "Hello,",
            "World!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun basic08Test(){
        usecases.basic08()
        Assert.assertEquals(100000, outputs.size)
    }

    @Test
    fun basic09Test(){
        usecases.basic09()
        val expectedOutputs = arrayListOf(
            "I'm sleeping 0 ...",
            "I'm sleeping 1 ...",
            "I'm sleeping 2 ...")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}