package honeycomb.android.ui.seekBars

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.widget.SeekBar
import honeycomb.android.R
import honeycomb.android.databinding.ViewSwipeBinding
import honeycomb.android.ui.dataBindings.ViewFactory
import honeycomb.android.ui.drawable.AnimationDrawableService
import honeycomb.domain.valuetypes.Percentage
import honeycomb.platform.android.widget.getProgressPercentage

class SwipeView(val binding: ViewSwipeBinding) {
    var _isSwiped = false

    val viewModel = binding.viewModel!!

    init {
        binding.viewSwipeSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (seekBar == null)
                    return

                if (seekBar.getProgressPercentage().isLessThan(Percentage.Percent.V090)) {
                    if(_isSwiped) {
                        _isSwiped = false
                        (binding.viewSwipeSeekbar.thumb as TransitionDrawable).reverseTransition(250)
                    }
                    return
                }

                if(!_isSwiped) {
                    _isSwiped = true
                    (binding.viewSwipeSeekbar.thumb as TransitionDrawable).startTransition(250)
                }
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

//        AnimationDrawableService.startAnimationDrawable(binding.viewSwipeSeekbar.thumb){
//            it.setExitFadeDuration(250)
//            it.setEnterFadeDuration(500)
//        }
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
