package honeycomb.android.ui.seekBars

import android.widget.SeekBar
import honeycomb.android.R
import honeycomb.android.databinding.ViewSwipeBinding
import honeycomb.android.ui.dataBindings.ViewFactory
import honeycomb.domain.valuetypes.Percentage
import honeycomb.platform.android.widget.getProgressPercentage

class SwipeView(val binding: ViewSwipeBinding) {
    val viewModel = binding.viewModel!!

    init {
        binding.viewSwipeSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                if (progress > 95) {
//                    seekBar?.thumb = seekBar!!.resources.getDrawable(R.drawable.ic_where_to_vote_32dp)
//                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar == null)
                    return

                if (seekBar.getProgressPercentage().isLessThan(Percentage.Percent.V090)) {
                    seekBar.progress = 0
                    return
                }

                seekBar.progress = seekBar.max
            }
        })
    }

    companion object {
        val factory = ViewFactory<ViewSwipeBinding, SwipeView>(R.id.view_movingbackground) {
            if (it.viewModel == null)
                it.viewModel = SwipeViewModel.create()

            val swipeView = SwipeView(it)
            it.view = swipeView
            return@ViewFactory swipeView
        }
    }
}
