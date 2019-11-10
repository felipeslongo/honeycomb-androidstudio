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

    private val viewModel = binding.viewModel!!

    fun start(){
        val animator = createValueAnimator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        bindAnimatorDuration(animator)
        animator.addUpdateListener(updateBackgroundMovement())
        animator.start()
    }

    private fun createValueAnimator() = when(binding.viewModel!!.isReversed.value) {
        true ->  ValueAnimator.ofFloat(0.0f, -1.0f)
        else -> ValueAnimator.ofFloat(0.0f, 1.0f)
    }

    private fun bindAnimatorDuration(animator: ValueAnimator) =
        viewModel.duration.observe(binding.lifecycleOwner!!, Observer { duration ->
        animator.duration = duration
    })

    private fun updateBackgroundMovement(): (ValueAnimator?) -> Unit {
        return { animation: ValueAnimator? ->
            val progress = animation!!.animatedValue as Float
            val width = binding.viewMovingbackgroundBackgroundOne.width
            val translationX = width * progress
            binding.viewMovingbackgroundBackgroundOne.translationX = translationX
            binding.viewMovingbackgroundBackgroundTwo.translationX = when(viewModel.isReversed.value!!){
                true -> translationX + width
                else -> translationX - width
            }
        }
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
