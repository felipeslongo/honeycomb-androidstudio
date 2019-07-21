package com.example.honeycomb.kotlin.coroutines

import kotlinx.coroutines.*

class LaunchUsecases {
    fun executeNestedWithCommonPoolContextLaunch(){
        CoroutineScope(Dispatchers.Default).launch {
            SuspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        Thread.sleep(100)
        CoroutineLogger.println("World!")
        Thread.sleep(200)//Ensure finished execution
    }

    /**
     * launch is a coroutine function. By not providing any context, it will get run on a different
     * thread. Hence the result as running Thread.start(). Essentially the code is run in
     * asynchronous in a parallel order.
     */
    fun executeNestedWithoutContextLaunch() = runBlocking{
        val task = launch {
            SuspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        delay(100)
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
            SuspendableTasks().voidTask()
        }

        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }

    /**
     * With join(), now this result looks like the Thread running on main thread result.
     * We could now guess that join() perhaps kick start the launch,
     * get it done before the normal code kicks off.
     */
    fun executeNestedWithContextAndJoinLaunch() = runBlocking{
        launch(coroutineContext) {
            SuspendableTasks().voidTask()
        }.join()

        CoroutineLogger.println("Hello")
        CoroutineLogger.println("World!")
    }
}