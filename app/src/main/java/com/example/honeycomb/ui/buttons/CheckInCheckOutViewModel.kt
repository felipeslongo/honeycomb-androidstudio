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

class CheckInCheckOutViewModel : ViewModel() {
    private val _isCheckedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _iconDrawableId: MutableLiveData<Int> = MutableLiveData(ICON)

    val isCheckedIn : LiveData<Boolean>
        get() = _isCheckedIn

    val textStringId : LiveData<Int> = Transformations.map(isCheckedIn){
        when{
            it -> CHECK_OUT
            else -> CHECK_IN
        }
    }

    val textColorResourceId : LiveData<Int> = Transformations.map(isCheckedIn){
        getColorResourceIdForTextAndIcon(it)
    }

    val iconDrawableId : LiveData<Int>
        get() = _iconDrawableId

    val iconTintColorResourceId : LiveData<Int> = Transformations.map(isCheckedIn){
        getColorResourceIdForTextAndIcon(it)
    }

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
    }
}