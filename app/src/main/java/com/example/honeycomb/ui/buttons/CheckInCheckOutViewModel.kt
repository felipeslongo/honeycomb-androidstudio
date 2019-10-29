package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.honeycomb.R

class CheckInCheckOutViewModel : ViewModel() {
    private val _textStringId: LiveData<Int> = MutableLiveData(R.string.check_in)
    private val _iconDrawableId: LiveData<Int> = MutableLiveData(R.drawable.ic_where_to_vote_24dp)
    private val _iconTint: LiveData<Int> = MutableLiveData(android.R.color.black)
    private val _isCheckedIn: LiveData<Boolean> = MutableLiveData(false)

    val textStringId : LiveData<Int>
        get() = _textStringId

    val iconDrawableId : LiveData<Int>
        get() = _iconDrawableId

    val iconTintColorId : LiveData<Int>
        get() = _iconTint

    val isCheckedIn : LiveData<Boolean>
        get() = _isCheckedIn
}