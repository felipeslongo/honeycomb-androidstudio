package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test
import java.io.PrintStream
import java.util.*
import kotlin.collections.ArrayList

class RunBlockingUsecasesTests {
    class printHelloWorldWithVoidTaskUsecaseTests{
        @Test
        fun shouldExecuteSynchronously(){
            val outputs = ArrayList<String>()
            SystemOutListener.instance.subscribe { outputs.add(it) }
            val usecases = RunBlockingUsecases()

            usecases.printHelloWorldWithVoidTaskUsecase()

            val expectedOutputs = arrayListOf(
                "Hello,",
                "start voidTask",
                "end voidTask",
                "World!")
            Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
        }
    }
}