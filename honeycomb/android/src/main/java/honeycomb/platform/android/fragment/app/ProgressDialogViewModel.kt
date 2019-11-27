package honeycomb.platform.android.fragment.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressDialogViewModel(viewState: ProgressDialogViewState) : ViewModel() {
    private val _progressText = MutableLiveData<String>(viewState.progressText)

    val progressText: LiveData<String> = _progressText

    fun setProgresText(text: String) {
        _progressText.value = text
    }
}