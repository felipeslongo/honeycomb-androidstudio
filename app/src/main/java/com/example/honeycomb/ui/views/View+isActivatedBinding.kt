package com.example.honeycomb.ui.views

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isActivatedBinding")
fun isActivatedBinding(view: View, state: Boolean){
    view.isActivated = state
}
