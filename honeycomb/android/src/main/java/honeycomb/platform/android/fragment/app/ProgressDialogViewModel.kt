package honeycomb.platform.android.fragment.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressDialogViewModel() : ViewModel() {
    private val _progressText = MutableLiveData("Please wait...")

    constructor(progressText: String) : this() {
        _progressText.value = progressText
    }

    val progressText: LiveData<String> = _progressText
}
