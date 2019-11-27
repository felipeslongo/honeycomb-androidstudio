package honeycomb.platform.android.fragment.app

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import honeycomb.android.R

class ProgressDialogViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val progressText = context.getString(R.string.body_please_wait)
        return ProgressDialogViewModel(progressText) as T
    }
}