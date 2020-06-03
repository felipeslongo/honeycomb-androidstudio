package honeycomb.kotlin

import kotlin.Exception

/**
 * Cast to Exception or wrap into a Exception class.
 *
 */
fun Throwable.wrapWithException() : Exception{
    if(this is Exception)
        return this as Exception

    return Exception(this)
}