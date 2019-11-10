package honeycomb.android.ui.imageViews

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import honeycomb.android.R
import honeycomb.android.databinding.ViewMovingbackgroundBinding

class MovingBackgroundView(val binding: ViewMovingbackgroundBinding) {
    companion object{
        fun createFromActivity(activity: AppCompatActivity){
            val binding = createBinding(activity.findViewById(R.id.view_movingbackground))
            MovingBackgroundView(binding)
            binding.lifecycleOwner = activity
        }

        private fun createBinding(root: FrameLayout): ViewMovingbackgroundBinding {
            return DataBindingUtil.bind(root)!!
        }
    }
}
