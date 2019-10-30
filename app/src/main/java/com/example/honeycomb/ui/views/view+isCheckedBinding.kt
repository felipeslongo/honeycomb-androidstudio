package com.example.honeycomb.ui.views

import android.view.View
import android.widget.Checkable
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isCheckedBinding")
fun isCheckedBinding(view: View, state: Boolean){
    val checkableView = view as Checkable
    checkableView.isChecked = state
}
