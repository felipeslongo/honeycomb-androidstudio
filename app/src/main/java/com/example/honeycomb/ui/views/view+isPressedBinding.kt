package com.example.honeycomb.ui.views

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isPressedBinding")
fun isPressedBinding(view: View, state: Boolean){
    view.isPressed = state
}
