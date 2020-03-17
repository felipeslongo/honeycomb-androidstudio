package honeycomb.platform.android.fragment.app

import android.content.DialogInterface
import androidx.fragment.app.DialogFragment
import honeycomb.kotlin.Event
import honeycomb.kotlin.EventHandler

/**
 * Utility that helps distinguish between a
 * dismissed by the user dialog and a
 * dismissed by the system dialog (e.g. rotation).
 *
 * Its important not to override the setOnDismissListener
 * and the setOnCancelListener because both are used
 * by this implementation.
 */
class DialogFragmentOnDismissObservable(fragment: DialogFragment) {
    private val _byAnyEventHandler = EventHandler<DialogInterface>()
    private val _bySystemEventHandler = EventHandler<DialogInterface>()
    private val _byUserEventHandler = EventHandler<DialogInterface>()

    init {
        fragment.dialog?.let {
            it.setOnCancelListener { dialogInterface ->
                _byUserEventHandler(dialogInterface)
                _byAnyEventHandler(dialogInterface)

                //onCancel is called BEFORE onDismiss in the DialogFragment lifecycle.
                //Therefore we can dispose here to prevent _bySystemEventHandler being triggered
                dispose()
            }
        } ?: throw IllegalArgumentException("Dialog in DialogFragment cannot be null.")

        fragment.dialog?.let {
            it.setOnDismissListener { dialogInterface ->
                _bySystemEventHandler(dialogInterface)
                _byAnyEventHandler(dialogInterface)

                //The Fragment is dismissed... there is no reason to hold reference to the observers
                dispose()
            }
        } ?: throw IllegalArgumentException("Dialog in DialogFragment cannot be null.")
    }

    val onDismiss: Event<DialogInterface> = _byAnyEventHandler
    val onDismissBySystem: Event<DialogInterface> = _bySystemEventHandler
    val onDismissByUser: Event<DialogInterface> = _byUserEventHandler

    fun observeOnDismissed(action: (DialogInterface) -> Unit) {
        onDismiss += action
    }

    fun observeOnDismissedBySystem(action: (DialogInterface) -> Unit) {
        onDismissBySystem += action
    }

    fun observeOnDismissedByUser(action: (DialogInterface) -> Unit) {
        onDismissByUser += action
    }

    private fun dispose() {
        _byAnyEventHandler.clear()
        _bySystemEventHandler.clear()
        _byUserEventHandler.clear()
    }
}
