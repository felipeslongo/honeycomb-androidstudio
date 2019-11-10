package honeycomb.android.ui.imageViews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import honeycomb.android.R

class MovingBackgroundViewModel : ViewModel() {
    private val _background = MutableLiveData(R.drawable.mercos_full)
    private val _isReversed = MutableLiveData(true)

    val background : LiveData<Int> = _background
    val isReversed : LiveData<Boolean> = _isReversed

    companion object {
        fun create() = MovingBackgroundViewModel()
    }
}
