package com.example.honeycomb.ui.mvvm

import kotlinx.coroutines.Job

/**
 * The Asynchronous Initialization Pattern
 * Marks a type as requiring asynchronous initialization
 * and provides the result of that initialization.
 * @see https://blog.stephencleary.com/2013/01/async-oop-2-constructors.html
 */
interface AsyncInitialization {
    /**
     * The result of the asynchronous initialization of this instance.
     */
    val initialization : Job
}
