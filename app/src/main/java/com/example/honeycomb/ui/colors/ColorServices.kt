package com.example.honeycomb.ui.colors

import android.content.Context
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat

class ColorServices {
    companion object{
        fun getColorStateList(context: Context, colorResourceId: Int) : ColorStateList{
            val color = ContextCompat.getColorStateList(context, colorResourceId)
            return color!!
        }
    }
}