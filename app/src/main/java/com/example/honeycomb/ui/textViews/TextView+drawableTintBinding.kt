package com.example.honeycomb.ui.textViews

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:drawableTintBinding")
fun drawableTintBinding(textView: TextView, colorResourceId: Int){
    textView.setCompoundDrawableTintList(colorResourceId)
}
