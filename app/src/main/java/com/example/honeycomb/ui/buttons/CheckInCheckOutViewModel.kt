package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.honeycomb.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CheckInCheckOutViewModel(private val _controller: CheckInCheckOutController) : ViewModel() {
    private val _isCheckedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isProcessing: MutableLiveData<Boolean> = MutableLiveData(true)
    private val _icon: MutableLiveData<Int> = MutableLiveData(ICON)

    init {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                _isCheckedIn.value = _controller.getCheckedInStateSuspendable()
            } finally {
                _isProcessing.value = false
            }
        }
    }

    val isCheckedIn : LiveData<Boolean>
        get() = _isCheckedIn

    val isProcessing: LiveData<Boolean>
        get() = _isProcessing

    val textStringId : LiveData<Int> = Transformations.map(isCheckedIn){
        when{
            it -> CHECK_OUT
            else -> CHECK_IN
        }
    }

    val textColor: LiveData<Int> = Transformations.map(isCheckedIn){
        getColorResourceIdForTextAndIcon(it)
    }

    val icon : LiveData<Int>
        get() = _icon

    val iconTint : LiveData<Int> = Transformations.map(isCheckedIn){
        getColorResourceIdForTextAndIcon(it)
    }

    //TODO Change GlobalScope to ViewModelScope
    fun interpretIntent(intent: ToggleCheckInCheckOutIntent) = GlobalScope.launch(Dispatchers.Main) {
        if(isProcessing.value!!)
            return@launch

        _isProcessing.value = true
        try {
            if(isCheckedIn.value!!) {
                checkOutSuspendable()
                return@launch
            }
            checkInSuspendable()
        } finally {
            _isProcessing.value = false
        }
    }

    private suspend fun checkInSuspendable() {
        _controller.checkInSuspendable()
        _isCheckedIn.value = true
    }

    private suspend fun checkOutSuspendable() {
        _controller.checkOutSuspendable()
        _isCheckedIn.value = false
    }

    companion object{
        const val ICON = R.drawable.ic_where_to_vote_32dp
        const val CHECK_IN =  R.string.checkincheckout_checkin
        const val CHECK_OUT =  R.string.checkincheckout_checkout

        fun create () : CheckInCheckOutViewModel {
            return CheckInCheckOutViewModel(CheckInCheckOutController.Create())
        }

        private fun getColorResourceIdForTextAndIcon(isCheckedIn: Boolean): Int {
            return when {
                isCheckedIn -> android.R.color.holo_red_light
                else -> android.R.color.black
            }
        }
    }
}