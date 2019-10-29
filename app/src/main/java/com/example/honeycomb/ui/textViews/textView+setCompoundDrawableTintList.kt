package com.example.honeycomb.ui.textViews

import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.example.honeycomb.ui.colors.ColorServices

fun TextView.setCompoundDrawableTintList(colorResourceId: Int){
    TextViewCompat.setCompoundDrawableTintList(this, ColorServices.getColorStateList(this.context, colorResourceId))
}
