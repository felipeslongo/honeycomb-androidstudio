package com.example.honeycomb.ui.seekBars

import androidx.lifecycle.ViewModel
import honeycomb.android.ui.seekBars.SwipeViewModel

class SwipeViewShowcaseViewModel : ViewModel() {
    val swipeViewModel = SwipeViewModel.create()

    fun notifyActivityCreated() {
        swipeViewModel.notifyActivityCreated()
    }
}
