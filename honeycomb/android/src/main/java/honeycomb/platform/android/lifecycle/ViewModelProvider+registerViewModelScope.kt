package honeycomb.platform.android.lifecycle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

inline fun <reified TViewModel : ViewModel> Fragment.registerViewModelScope(viewModel: TViewModel) {
    getViewModel { viewModel }
}

inline fun <reified TViewModel : ViewModel> FragmentActivity.registerViewModelScope(viewModel: TViewModel) {
    getViewModel { viewModel }
}
