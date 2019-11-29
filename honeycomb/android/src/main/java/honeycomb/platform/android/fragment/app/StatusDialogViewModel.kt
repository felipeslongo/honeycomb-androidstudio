package honeycomb.platform.android.fragment.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StatusDialogViewModel() : ViewModel() {
    private val _buttonText = MutableLiveData("Ok")
    private val _isVisible = MutableLiveData(false)
    private val _statusText = MutableLiveData("Operação realizada com sucesso!")

    constructor(isVisible: Boolean, statusText: String) : this() {
        _isVisible.value = isVisible
        _statusText.value = statusText
    }

    val buttonText: LiveData<String> = _buttonText
    val isVisible: LiveData<Boolean> = _isVisible
    val statusText: LiveData<String> = _statusText

    var buttonTextValue: String
        get() = buttonText.value!!
        set(value) {
            _buttonText.value = value
        }

    var isVisibleValue: Boolean
        get() = isVisible.value!!
        set(value) {
            _isVisible.value = value
        }

    var statusTextValue: String
        get() = statusText.value!!
        set(value) {
            _statusText.value = value
        }

    fun present() {
        isVisibleValue = true
    }

    fun dismiss() {
        isVisibleValue = false
    }

    fun dismissAfter(timeMillis: Long) {
        viewModelScope.launch {
            delay(timeMillis)
            dismiss()
        }
    }

    fun notifyOnUserPositiveButtonClick() {
        isVisibleValue = false
    }

    fun notifyOnDialogDismissed() {
        dismiss()
    }

    fun notifyOnDialogCancel() {
        dismiss()
    }
}
