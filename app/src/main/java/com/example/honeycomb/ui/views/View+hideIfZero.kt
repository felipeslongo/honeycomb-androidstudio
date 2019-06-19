package com.example.honeycomb.ui.views

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:hideIfZero")
fun View.hideIfZero(number: Int){
    this.visibility = if (number == 0) View.GONE else View.VISIBLE
}