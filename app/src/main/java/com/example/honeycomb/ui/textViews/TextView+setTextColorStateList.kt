package com.example.honeycomb.ui.textViews

import android.widget.TextView
import com.example.honeycomb.ui.colors.ColorServices

fun TextView.setTextColorStateList(colorResourceId: Int){
    val color = ColorServices.getColorStateList(context,colorResourceId)
    setTextColor(color)
}
