package honeycomb.android.ui.imageViews

import androidx.lifecycle.Observer
import honeycomb.android.R
import honeycomb.android.databinding.ViewMovingbackgroundBinding
import honeycomb.android.ui.dataBindings.ViewFactory
import honeycomb.platform.android.view.addOnWidthChangeListener

/**
 * View that provides an moving background animation horizontally.
 * @see https://stackoverflow.com/questions/36894384/android-move-background-continuously-with-animation
 */
class MovingBackgroundView(val binding: ViewMovingbackgroundBinding) {
    val viewModel = binding.viewModel!!

    init {
        fun notifyWidthChanges(){
            binding.viewMovingbackgroundBackgroundOne.addOnWidthChangeListener {
                viewModel.notifyWidthChanged(it)
            }
        }

        fun observeAndRenderBackgroundViewOneTranslationXChanges(){
            viewModel.backgroundViewOneTranslationX.observe(binding.lifecycleOwner!!, Observer {
                binding.viewMovingbackgroundBackgroundOne.translationX = it
            })
        }

        fun observeAndRenderBackgroundViewTwoTranslationXChanges(){
            viewModel.backgroundViewTwoTranslationX.observe(binding.lifecycleOwner!!, Observer {
                binding.viewMovingbackgroundBackgroundTwo.translationX = it
            })
        }

        notifyWidthChanges()
        observeAndRenderBackgroundViewOneTranslationXChanges()
        observeAndRenderBackgroundViewTwoTranslationXChanges()
    }

    companion object{
        val factory =
            ViewFactory<ViewMovingbackgroundBinding, MovingBackgroundView>(R.id.view_movingbackground) {
                if (it.viewModel == null)
                    it.viewModel = MovingBackgroundViewModel.create()
                return@ViewFactory MovingBackgroundView(it)
        }
    }
}
