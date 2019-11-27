package honeycomb.platform.android.fragment.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProgressDialogViewModelFactory(private val viewState: ProgressDialogViewState) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProgressDialogViewModel(viewState) as T
    }
}