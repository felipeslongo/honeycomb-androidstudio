package honeycomb.platform.android.widget

import android.widget.SeekBar

fun SeekBar.getProgressPercentage(): Float {
    return progress.toFloat() / max.toFloat()
}
