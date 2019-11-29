package com.example.honeycomb.ui.main

import androidx.lifecycle.ViewModel
import honeycomb.platform.android.fragment.app.ProgressDialogViewModel
import honeycomb.platform.android.fragment.app.StatusDialogViewModel

class MainViewModel : ViewModel() {
    val progressDialogViewModel = ProgressDialogViewModel(false, "Performing Check-In...")
    val statusDialogViewModel =
        StatusDialogViewModel(false, "Check-In realizado com sucesso!").apply {
            buttonTextValue = "Prosseguir"
        }
}
