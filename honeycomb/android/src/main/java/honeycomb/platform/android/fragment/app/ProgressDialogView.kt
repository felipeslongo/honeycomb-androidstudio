package honeycomb.platform.android.fragment.app

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import honeycomb.platform.android.lifecycle.getViewModel

class ProgressDialogView(
    private val _activity: AppCompatActivity,
    private val _viewModel: ProgressDialogViewModel
) {

    init {
        _activity.getViewModel {
            _viewModel
        }

        initBindings()
    }

    private fun initBindings() {
        _viewModel.isVisible.observe(_activity, Observer {
            if (it == false)
                return@Observer

            ProgressDialogFragment.present(_activity.supportFragmentManager)
        })
    }
}