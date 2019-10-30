package com.example.honeycomb.ui.textViews

import android.view.View
import android.widget.Checkable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.honeycomb.ui.colors.ColorServices

@BindingAdapter("app:textColorResourceBinding")
fun textColorResourceBinding(view: TextView, colorResourceId: Int){
    val color = ColorServices.getColorStateList(view.context,colorResourceId)
    view.setTextColor(color)
}
