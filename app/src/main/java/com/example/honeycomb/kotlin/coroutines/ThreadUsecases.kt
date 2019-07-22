package com.example.honeycomb.kotlin.coroutines

class ThreadUsecases {
    /**
     * Calling Thread.run() for a Thread isn’t do anything other than like a normal run on the same
     * thread (i.e. main thread in this case). The code get run synchronously in a sequential manner.
     * (i.e. code run per the order of the line)
     */
    fun executeWithRun() {
        Thread {
            SuspendableTasks().voidTaskUsingSleep()
        }.run()

        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
    }

    /**
     * Calling Thread.start() for a Thread is actuall starting a new thread, i.e. Thread-0 thread.
     * The code get run asynchronously, as the two threads are run in parallel.
     */
    fun executeWithStart() {
        val thread = Thread {
            SuspendableTasks().voidTaskUsingSleep()
        }
        thread.start()

        CoroutineLogger.println("Hello")
        Thread.sleep(10)
        CoroutineLogger.println("World!")
        thread.join()
    }
}