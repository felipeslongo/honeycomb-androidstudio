package honeycomb.platform.android.fragment.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressDialogViewModel() : ViewModel() {
    private val _isVisible = MutableLiveData(false)
    private val _progressText = MutableLiveData("Please wait...")

    constructor(progressText: String) : this() {
        _progressText.value = progressText
    }

    val isVisible: LiveData<Boolean> = _isVisible
    val progressText: LiveData<String> = _progressText

    fun show() {
        _isVisible.value = true
    }

    fun hide() {
        _isVisible.value = false
    }

    fun hideAfter(timeMillis: Long) {
        viewModelScope.launch {
            delay(timeMillis)
            _isVisible.value = false
        }
    }
}
