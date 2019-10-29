package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.honeycomb.R

class CheckInCheckOutViewModel : ViewModel() {
    private val _iconDrawableId: LiveData<Int> = MutableLiveData(R.drawable.ic_where_to_vote_24dp)

    val iconDrawableId : LiveData<Int>
        get() = _iconDrawableId
}