package honeycomb.android.ui.imageViews

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import honeycomb.android.R

class MovingBackgroundViewModel : ViewModel() {
    private val _animator = lazy { createValueAnimator() }
    private val _background = MutableLiveData(R.drawable.mercos_full)
    private val _backgroundViewOneTranslationX = MutableLiveData<Float>(0f)
    private val _duration = MutableLiveData(DURATION_NORMAL)
    private val _isReversed = MutableLiveData(false)
    private val _isStarted = MutableLiveData(false)
    private var _width = 0

    val background : LiveData<Int> = _background
    val backgroundViewOneTranslationX: LiveData<Float> = _backgroundViewOneTranslationX
    val backgroundViewTwoTranslationX = Transformations.map(backgroundViewOneTranslationX) {
        when (isReversed.value!!) {
            true -> it + _width
            else -> it - _width
        }
    }
    val duration: LiveData<Long> = _duration
    val isReversed : LiveData<Boolean> = _isReversed
    val isStarted : LiveData<Boolean> = _isStarted

    init {
        isStarted.observeForever { isStarted ->
            if (isStarted) {
                _animator.value.start()
                return@observeForever
            }
            _animator.value.end()
        }

        isReversed.observeForever { isReversed ->
            if (isReversed) {
                _animator.value.setFloatValues(0.0f, -1.0f)
                return@observeForever
            }
            _animator.value.setFloatValues(0.0f, 1.0f)
        }
    }

    private fun createValueAnimator(): ValueAnimator {
        fun observeDurationChanges(animator: ValueAnimator) = duration.observeForever {
            animator.duration = it
        }

        fun getValueAnimatorValues() = FloatArray(2) {
            when (it) {
                0 -> 0.0f
                else -> when (isReversed.value) {
                    true -> -1.0f
                    else -> 1.0f
                }
            }
        }

        fun updateBackgroundMovement(): (ValueAnimator?) -> Unit {
            return { animation: ValueAnimator? ->
                val progress = animation!!.animatedValue as Float
                val translationX = _width * progress
                _backgroundViewOneTranslationX.value = translationX
            }
        }

        val animator = ValueAnimator.ofFloat(*getValueAnimatorValues())
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        observeDurationChanges(animator)
        animator.addUpdateListener(updateBackgroundMovement())
        return animator
    }

    fun notifyWidthChanged(width: Int) {
        _width = width
    }

    override fun onCleared() {
        super.onCleared()
        if (_animator.isInitialized())
            _animator.value.end()
    }

    fun reverse() {
        _isReversed.value = !_isReversed.value!!
    }

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

    fun setMovingBackground(drawableId: Int) {
        _background.value = drawableId
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
