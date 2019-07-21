package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.SystemOutListener
import org.junit.Assert
import org.junit.Test
import kotlin.collections.ArrayList

class RunBlockingUsecasesTests {
    class executeUsecase1Tests{
        @Test
        fun shouldExecuteSynchronously(){
            val outputs = ArrayList<String>()
            SystemOutListener.instance.subscribe { outputs.add(it) }
            val usecases = RunBlockingUsecases()

            usecases.executeUsecase1()

            val expectedOutputs = arrayListOf(
                "Hello,",
                "start voidTask",
                "end voidTask",
                "World!")
            Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
        }
    }

    class executeUsecase2Tests{
        @Test
        fun shouldExecuteSynchronously(){
            val outputs = ArrayList<String>()
            SystemOutListener.instance.subscribe { outputs.add(it) }
            val usecases = RunBlockingUsecases()

            usecases.executeUsecase2()

            val expectedOutputs = arrayListOf(
                "Hello,",
                "start voidTask",
                "end voidTask",
                "World!")
            Assert.assertArrayEquals(expectedOutputs.toArray(), outputs.toArray())
        }
    }
}