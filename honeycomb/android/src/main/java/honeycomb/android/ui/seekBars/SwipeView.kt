package honeycomb.android.ui.seekBars

import honeycomb.android.R
import honeycomb.android.databinding.ViewSwipeBinding
import honeycomb.android.ui.dataBindings.ViewFactory

class SwipeView(val binding: ViewSwipeBinding) {
    val viewModel = binding.viewModel!!

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
