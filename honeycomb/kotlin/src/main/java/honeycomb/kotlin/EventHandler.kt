package honeycomb.kotlin

/**
 * C# style EventHandler in Kotlin.
 * Encapsulate privately this member so only your class can invoke it.
 * Expose Event interface instead of this publicly.
 *
 * Author/Credits to:
 *      https://gist.github.com/orangy/11178911
 *      https://discuss.kotlinlang.org/t/c-style-events/2076
 */
class EventHandler<TEventArgs> : Event<TEventArgs> {
    private val _handlers = arrayListOf<((TEventArgs) -> Unit)>()
    override operator fun plusAssign(handler: (TEventArgs) -> Unit) {
        _handlers.add(handler)
    }

    override operator fun minusAssign(handler: (TEventArgs) -> Unit) {
        _handlers.remove(handler)
    }

    operator fun invoke(eventArgs: TEventArgs) {
        for (handler in _handlers) handler(eventArgs)
    }

    fun clear() {
        _handlers.clear()
    }

    operator fun plusAssign(handler: EventHandler<TEventArgs>.(TEventArgs) -> Unit) {
        _handlers.add { handler(it) }
    }

    operator fun minusAssign(handler: EventHandler<TEventArgs>.(TEventArgs) -> Unit) {
        _handlers.add { handler(it) }
    }

//    private val _handlers = arrayListOf<(EventHandler<TEventArgs>.(TEventArgs) -> Unit)>()
//    operator fun plusAssign(handler: EventHandler<TEventArgs>.(TEventArgs) -> Unit) { _handlers.add(handler) }
//    operator fun minusAssign(handler: EventHandler<TEventArgs>.(TEventArgs) -> Unit) { _handlers.remove(handler) }
//    operator fun invoke(eventArgs: TEventArgs){ for (handler in _handlers) handler(eventArgs) }
}

