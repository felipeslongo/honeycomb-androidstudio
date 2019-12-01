package honeycomb.kotlin

/**
 * C# style EventHandler in Kotlin
 * Use this to expose your EventHandler publicly
 */
interface Event<TEventArgs> {
    operator fun plusAssign(handler: (TEventArgs) -> Unit)
    operator fun minusAssign(handler: (TEventArgs) -> Unit)
}
