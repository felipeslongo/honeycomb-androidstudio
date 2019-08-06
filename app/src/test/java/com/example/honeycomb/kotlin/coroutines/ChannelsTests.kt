package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Before

class ChannelsTests {
    private val outputs = ArrayList<String>()
    private val usecases = CancellationAndTimeouts()

    @Before
    fun setup(){
        outputs.clear()
        SystemOutListener.instance.subscribe {
            outputs.add(it) }
    }


}