package honeycomb.android.ui.imageViews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import honeycomb.android.R

class MovingBackgroundViewModel : ViewModel() {
    private val _background = MutableLiveData(R.drawable.mercos_full)
    private val _duration = MutableLiveData(10000L)
    private val _isReversed = MutableLiveData(false)

    val background : LiveData<Int> = _background
    val duration: LiveData<Long> = _duration
    val isReversed : LiveData<Boolean> = _isReversed

    fun slowDown() {
        _duration.value = _duration.value!! * 2
    }

    fun speedUp() {
        _duration.value = _duration.value!! / 2
    }

    companion object {
        fun create() = MovingBackgroundViewModel()
    }
}
