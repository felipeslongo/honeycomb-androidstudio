package com.example.honeycomb.ui.mvvm

import androidx.lifecycle.LiveData

/**
 * Encapsulates a Boolean LiveData indicating whether the ViewModel is running
 * an asynchronous operation.
 */
interface Busyable {
    val isBusy: LiveData<Boolean>
}
