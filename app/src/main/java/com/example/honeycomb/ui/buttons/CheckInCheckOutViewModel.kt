package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.honeycomb.R

class CheckInCheckOutViewModel : ViewModel() {
    private val _isCheckedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _iconDrawableId: MutableLiveData<Int> = MutableLiveData(R.drawable.ic_where_to_vote_24dp)

    val isCheckedIn : LiveData<Boolean>
        get() = _isCheckedIn

    val textStringId : LiveData<Int> = Transformations.map(isCheckedIn){
        when{
            it -> R.string.check_out
            else -> R.string.check_in
        }
    }

    val textColorResourceId : LiveData<Int> = Transformations.map(isCheckedIn){
        when{
            it -> android.R.color.holo_red_dark
            else -> android.R.color.black
        }
    }

    val iconDrawableId : LiveData<Int>
        get() = _iconDrawableId

    val iconTintColorResourceId : LiveData<Int> = Transformations.map(isCheckedIn){
        when{
            it -> android.R.color.holo_red_dark
            else -> android.R.color.black
        }
    }

    fun toogleCheckInCheckOut(){
        _isCheckedIn.value = !_isCheckedIn.value!!
        if(_isCheckedIn.value!!){
            checkOut()
            return
        }
        checkIn()
    }

    private fun checkIn() {
    }

    private fun checkOut() {
    }
}