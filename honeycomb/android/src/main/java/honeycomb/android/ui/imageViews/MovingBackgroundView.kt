package honeycomb.android.ui.imageViews

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import honeycomb.android.R
import honeycomb.android.databinding.ViewMovingbackgroundBinding

/**
 * View that provides an moving background animation horizontally.
 * @see https://stackoverflow.com/questions/36894384/android-move-background-continuously-with-animation
 */
class MovingBackgroundView(val binding: ViewMovingbackgroundBinding) {

    private val _animator = lazy {
        val animator = createValueAnimator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        bindAnimatorDuration(animator)
        animator.addUpdateListener(updateBackgroundMovement())
        animator
    }

    val viewModel = binding.viewModel!!

    init {
        viewModel.isStarted.observe(binding.lifecycleOwner!!, Observer {isStarted ->
            if (isStarted) {
                _animator.value.start()
                return@Observer
            }
            _animator.value.end()
        })
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
            return createFromBinding(binding, activity)
        }

        fun createFromBinding(
            binding: ViewMovingbackgroundBinding,
            lifecycleOwner: LifecycleOwner
        ): MovingBackgroundView {
            binding.lifecycleOwner = lifecycleOwner
            if (binding.viewModel == null)
                binding.viewModel = MovingBackgroundViewModel.create()
            return MovingBackgroundView(binding)
        }

        fun createFromFragment(fragment: Fragment) =
            createFromFragment(fragment, R.id.view_movingbackground)

        fun createFromFragment(fragment: Fragment, id: Int): MovingBackgroundView {
            val binding = createBinding(fragment.view!!.findViewById(id))
            return createFromBinding(binding, fragment)
        }

        private fun createBinding(root: FrameLayout): ViewMovingbackgroundBinding {
            return DataBindingUtil.bind(root)!!
        }
    }

}
