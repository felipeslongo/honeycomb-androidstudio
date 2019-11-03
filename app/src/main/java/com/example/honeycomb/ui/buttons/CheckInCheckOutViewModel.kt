package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.honeycomb.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CheckInCheckOutViewModel(val controller: CheckInCheckOutController) : ViewModel() {
    private val _isCheckedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _icon: MutableLiveData<Int> = MutableLiveData(ICON)

    val isCheckedIn : LiveData<Boolean>
        get() = _isCheckedIn

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

    val checkInCommand = lazy { CheckInCommand(MutableLiveData(true)) { controller.checkIn() } }
    val checkOutCommand = lazy { CheckOutCommand { controller.checkOut() } }

    //TODO Change GlobalScope to ViewModelScope
    fun toogleCheckInCheckOut() = GlobalScope.launch(Dispatchers.Main) {
        delay(1000)
        _isCheckedIn.value = !_isCheckedIn.value!!
        if (_isCheckedIn.value!!) {
            checkOut()
        } else{
            checkIn()
        }
    }

    private fun checkIn() {
    }

    private fun checkOut() {
    }

    private fun getColorResourceIdForTextAndIcon(isCheckedIn: Boolean): Int {
        return when {
            isCheckedIn -> android.R.color.holo_red_light
            else -> android.R.color.black
        }
    }

    companion object{
        const val ICON = R.drawable.ic_where_to_vote_32dp
        const val CHECK_IN =  R.string.check_in
        const val CHECK_OUT =  R.string.check_out

        fun Create () : CheckInCheckOutViewModel {
            return CheckInCheckOutViewModel(CheckInCheckOutController.Create())
        }
    }
}