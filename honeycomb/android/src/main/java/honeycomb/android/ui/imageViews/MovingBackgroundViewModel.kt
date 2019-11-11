package honeycomb.android.ui.imageViews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import honeycomb.android.R

class MovingBackgroundViewModel : ViewModel() {
    private val _background = MutableLiveData(R.drawable.mercos_full)
    private val _duration = MutableLiveData(DURATION_NORMAL)
    private val _isReversed = MutableLiveData(false)
    private val _isStarted = MutableLiveData(false)

    val background : LiveData<Int> = _background
    val duration: LiveData<Long> = _duration
    val isReversed : LiveData<Boolean> = _isReversed
    val isStarted : LiveData<Boolean> = _isStarted

    fun setSpeed(speed: Speed){
        _duration.value = when(speed) {
            Speed.SLOW -> DURATION_NORMAL * 2
            Speed.NORMAL -> DURATION_NORMAL
            Speed.FAST -> DURATION_NORMAL / 2
        }
    }

    fun setDuration(duration: Long) {
        _duration.value = duration
    }

    fun slowDown() {
        _duration.value = _duration.value!! * 2
    }

    fun speedUp() {
        _duration.value = _duration.value!! / 2
    }

    fun start(){
        _isStarted.value = true
    }

    fun stop(){
        _isStarted.value = false
    }

    companion object {
        private const val DURATION_NORMAL = 10000L

        fun create() = MovingBackgroundViewModel()
    }

    enum class Speed {
        SLOW,
        NORMAL,
        FAST,
    }
}
