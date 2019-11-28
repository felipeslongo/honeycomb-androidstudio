package com.example.honeycomb.ui.main

import androidx.lifecycle.ViewModel
import honeycomb.platform.android.fragment.app.ProgressDialogViewModel

class MainViewModel : ViewModel() {
    val progressDialogViewModel = ProgressDialogViewModel(false, "Performing Check-In...")
}
