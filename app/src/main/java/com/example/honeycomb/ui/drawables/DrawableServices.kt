package com.example.honeycomb.ui.drawables

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.honeycomb.R

class DrawableServices {
    companion object{
        fun createAvatar(resources: Resources, drawableId: Int) : Drawable{
            var bitmap = BitmapFactory.decodeResource(resources, drawableId)

//            //https://stackoverflow.com/questions/15789049/crop-a-bitmap-image
//            val size = Math.min(bitmap.height, bitmap.width)
//            bitmap = Bitmap.createBitmap(bitmap, 0,0,size, size)

            val roundedDrawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
            roundedDrawable.isCircular = true
            roundedDrawable.setAntiAlias(true)

            return roundedDrawable
        }
    }
}