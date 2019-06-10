package com.example.honeycomb.ui.drawables

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.honeycomb.R

class DrawableServices {
    companion object{
        fun createAvatar(resources: Resources, drawableId: Int) : Drawable{
            val bitmap = BitmapFactory.decodeResource(resources, drawableId)
            val roundedDrawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
            roundedDrawable.isCircular = true

            return roundedDrawable
        }
    }
}