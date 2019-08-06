package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChannelsTests {
    private val outputs = ArrayList<String>()
    private val usecases = Channels()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it) }
    }

    @Test
    fun usecase01BasicsTest(){
        usecases.usecase01Basics()
        val expectedOutputs = arrayListOf(
            "1", "4", "9", "16", "25", "Done!")
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }

    @Test
    fun usecase02ClosingAndIterationOverChannelsTest() {
        usecases.usecase02ClosingAndIterationOverChannels()
        val expectedOutputs = arrayListOf(
            "1", "4", "9", "16", "25", "Done!"
        )
        Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
    }
}