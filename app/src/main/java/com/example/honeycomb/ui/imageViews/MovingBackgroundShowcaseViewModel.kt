package com.example.honeycomb.ui.imageViews

import androidx.lifecycle.ViewModel
import honeycomb.android.ui.imageViews.MovingBackgroundViewModel

class MovingBackgroundShowcaseViewModel : ViewModel() {

    val movingBackgroundFastViewModel = MovingBackgroundViewModel.create()
    val movingBackgroundInverseViewModel = MovingBackgroundViewModel.create()
    val movingBackgroundSlowViewModel = MovingBackgroundViewModel.create()
    val movingBackgroundViewModel = MovingBackgroundViewModel.create()

    fun notifyActivityCreated() {
        movingBackgroundViewModel.start()

        movingBackgroundSlowViewModel.slowDown()
        movingBackgroundSlowViewModel.start()

        movingBackgroundFastViewModel.speedUp()
        movingBackgroundFastViewModel.start()

        movingBackgroundInverseViewModel.reverse()
        movingBackgroundInverseViewModel.start()
    }

}
