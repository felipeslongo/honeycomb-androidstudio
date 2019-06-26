package com.example.honeycomb.ui.drawables

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.example.honeycomb.R

class DrawableServices {
    companion object{
        fun createAvatar(resources: Resources, drawableId: Int) : Drawable{
            var bitmap = BitmapFactory.decodeResource(resources, drawableId)

            bitmap = createSquare(bitmap)
            val roundedDrawable = createCircle(resources, bitmap)

            return roundedDrawable
        }

        fun createAvatarWithAspectRatio(resources: Resources, drawableId: Int) : Drawable{
            var bitmap = BitmapFactory.decodeResource(resources, drawableId)

            val roundedDrawable = createCircle(resources, bitmap)

            return roundedDrawable
        }

        private fun createCircle(resources: Resources, bitmap: Bitmap?): RoundedBitmapDrawable {
            val roundedDrawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
            roundedDrawable.isCircular = true
            roundedDrawable.setAntiAlias(true)
            return roundedDrawable
        }

        fun createSquare(bitmap: Bitmap): Bitmap {
            //https://stackoverflow.com/questions/15789049/crop-a-bitmap-image
            val size = Math.min(bitmap.height, bitmap.width)
            var x = bitmap.width - size
            var y = bitmap.height - size
            if (x > 0)
                x /= 2
            if (y > 0)
                y /= 2

            return Bitmap.createBitmap(bitmap, x, y, size, size)
        }
    }
}