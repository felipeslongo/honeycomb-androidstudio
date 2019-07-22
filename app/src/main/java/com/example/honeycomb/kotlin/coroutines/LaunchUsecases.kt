package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*

class LaunchUsecases {
    fun executeNestedWithCommonPoolContextLaunch(){
        val job = CoroutineScope(Dispatchers.Default).launch {
            SuspendableTasks().voidTaskUsingSleep(1000)
        }

        CoroutineLogger.println("Hello")
        Thread.sleep(200)
        CoroutineLogger.println("World!")
        Thread.sleep(200)//Ensure finished execution

        runBlocking {
            job.join()
        }
    }

    /**
     * launch is a coroutine function. By not providing any context, it will get run on a different
     * thread. Hence the result as running Thread.start(). Essentially the code is run in
     * asynchronous in a parallel order.
     */
    fun executeNestedWithoutContextLaunch() = runBlocking{
        launch(Dispatchers.Default) {
            SuspendableTasks().voidTaskUsingSleep(1000)
        }

        Thread.sleep(100)
        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
    }

    /**
     * The use of coroutineContext is to enable launch to run on the main thread.
     * However coroutineContext is only available in the runBlocking scope,
     * hence I wrap everything under runBlocking.
     *
     * The result shows something that is very different from Thread as well.
     * It is not running synchronously in a sequential manner. Instead,
     * the launch's code get run last, after the normal code completed.
     *
     * This is an expected behavior, where by default the code in launch will only triggered after
     * the main calling function completed it’s code.
     */
    fun executeNestedWithContextLaunch() = runBlocking{
        launch(coroutineContext) {
            SuspendableTasks().voidTaskUsingSleep(1000)
        }

        CoroutineLogger.println("Hello")
        Thread.sleep(200)
        CoroutineLogger.println("World!")
    }

    /**
     * With join(), now this result looks like the Thread running on main thread result.
     * We could now guess that join() perhaps kick start the launch,
     * get it done before the normal code kicks off.
     */
    fun executeNestedWithContextAndJoinLaunch() = runBlocking{
        launch(coroutineContext) {
            SuspendableTasks().voidTaskUsingSleep(1000)
        }.join()

        CoroutineLogger.println("Hello")
        Thread.sleep(200)
        CoroutineLogger.println("World!")
    }

    /**
     * In this example, we store the launch result as job. Then later while running the normal code,
     * we get it kick off by calling join().
     *
     * The result looks blocking though as the launch code need to complete before the the normal
     * code continues. Looks like runBlocking.
     *
     * In actual fact, launch are not support to be blocking
     */
    fun executeNestedWithContextAndJoinLaterLaunch() = runBlocking{
        val job = launch(coroutineContext) {
            SuspendableTasks().voidTaskUsingSleep(1000)
        }

        CoroutineLogger.println("Hello")
        Thread.sleep(200)
        job.join()
        CoroutineLogger.println("World!")
    }

    /**
     * Now replace the Thread.sleep(..) to delay(..). Delay is a non-blocking suspending function.
     *
     * The very unique part of this code is, it is all run in the main thread, yet the result looks
     * like run asynchronously parallel. It is actually run synchronously parallel, where the
     * delay(…) doesn’t block the main normal code from continuing.
     *
     * Hope this gives a very clear distinct different of coroutine with Thread.
     * It could get code running on the same thread, but in a seemingly parallel mode.
     */
    fun executeNestedWithContextAndDelayLaunch() = runBlocking{
        launch(coroutineContext) {
            SuspendableTasks().voidTask(1000)
        }

        CoroutineLogger.println("Hello")
        delay(200)
        CoroutineLogger.println("World!")
    }
}