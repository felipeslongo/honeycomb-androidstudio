package honeycomb.platform.android.view

import android.view.View


/**
 * Add a listener that will be called
 * when the height of the view change
 * due to layout processing.
 * @see https://stackoverflow.com/questions/4174613/how-to-detect-a-layout-resize
 */
fun View.addOnHeightChangeListener(action: (height: Int) -> Unit) {
    this.addOnLayoutChangeListener { view, _, _, _, _, _, oldTop, _, oldBottom ->
        val heightWas = oldBottom - oldTop // bottom exclusive, top inclusive
        if (view.height == heightWas)
            return@addOnLayoutChangeListener

        action(view.height)
    }
}
