package honeycomb.platform.android.view

import android.view.View

/**
 * Add a listener that will be called
 * when the width of the view change
 * due to layout processing.
 * @see https://stackoverflow.com/questions/4174613/how-to-detect-a-layout-resize
 */
fun View.addOnWidthChangeListener(action: (width: Int) -> Unit) {
    this.addOnLayoutChangeListener { view, _, _, _, _, oldLeft, _, oldRight, _ ->
        val widthWas = oldRight - oldLeft // right exclusive, left inclusive
        if (view.width == widthWas)
            return@addOnLayoutChangeListener

        action(view.width)
    }
}
