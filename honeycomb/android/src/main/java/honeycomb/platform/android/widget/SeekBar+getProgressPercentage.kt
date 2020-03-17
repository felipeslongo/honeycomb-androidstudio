package honeycomb.platform.android.widget

import android.widget.SeekBar
import honeycomb.domain.valuetypes.Percentage

/**
 * Gets the percent ratio between the current [SeekBar.getProgress]
 * and the [SeekBar.getMax] progress values.
 * @return [Percentage] instance.
 * @throws IllegalArgumentException when [SeekBar.getMax] is zero.
 */
fun SeekBar.getProgressPercentage(): Percentage {
    require(max != 0) { "Property SeekBar.max must be non zero." }
    return Percentage.create(progress, max)
}
