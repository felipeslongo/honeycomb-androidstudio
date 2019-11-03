package com.example.honeycomb.ui.views

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isActivated")
fun isActivated(view: View, state: Boolean){
    view.isActivated = state
}
