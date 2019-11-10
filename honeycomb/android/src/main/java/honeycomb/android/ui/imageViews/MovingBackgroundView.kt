package honeycomb.android.ui.imageViews

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import honeycomb.android.R
import honeycomb.android.databinding.ViewMovingbackgroundBinding

/**
 * Moving Background View
 * @see https://stackoverflow.com/questions/36894384/android-move-background-continuously-with-animation
 */
class MovingBackgroundView(val binding: ViewMovingbackgroundBinding) {

    fun start(){
        val animator = createValueAnimator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        binding.viewModel!!.duration.observe(binding.lifecycleOwner!!, Observer {duration ->
            animator.duration = duration
        })
        animator.duration = 10000L
        animator.addUpdateListener {animation: ValueAnimator? ->
            val progress = animation!!.animatedValue as Float
            val width = binding.viewMovingbackgroundBackgroundOne.width
            val translationX = width * progress
            binding.viewMovingbackgroundBackgroundOne.translationX = translationX
            if(binding.viewModel!!.isReversed.value!!)
                binding.viewMovingbackgroundBackgroundTwo.translationX = translationX + width
            else
                binding.viewMovingbackgroundBackgroundTwo.translationX = translationX - width
        }

        animator.start()
    }

    private fun createValueAnimator() = when(binding.viewModel!!.isReversed.value) {
        true ->  ValueAnimator.ofFloat(0.0f, -1.0f)
        else -> ValueAnimator.ofFloat(0.0f, 1.0f)
    }

    companion object{
        fun createFromActivity(activity: AppCompatActivity) : MovingBackgroundView{
            val binding = createBinding(activity.findViewById(R.id.view_movingbackground))
            binding.lifecycleOwner = activity
            binding.viewModel = MovingBackgroundViewModel.create()
            return MovingBackgroundView(binding)
        }

        private fun createBinding(root: FrameLayout): ViewMovingbackgroundBinding {
            return DataBindingUtil.bind(root)!!
        }
    }

}
