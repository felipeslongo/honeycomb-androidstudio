package com.example.honeycomb.ui.imageViews

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

fun ImageView.setImageTintColorWithAnotherViewBackgroundColor(anotherView: ViewParent){
    val asView = anotherView as View? ?: return
    setImageTintColorWithAnotherViewBackgroundColor(asView)
}

fun ImageView.setImageTintColorWithAnotherViewBackgroundColor(anotherView: View){
    val colorDrawable = anotherView.background as ColorDrawable? ?: return
    setImageTintColor(colorDrawable.color)
}


fun ImageView.setImageTintColor(colorInt: Int){
    //https://stackoverflow.com/questions/20121938/how-to-set-tint-for-an-image-view-programmatically-in-android
    val tint = ColorStateList.valueOf(colorInt)
    ImageViewCompat.setImageTintList(this, tint)
}

fun ImageView.setImageTintColorWithResource(colorId: Int){
    val colorInt = ContextCompat.getColor(context, colorId)
    setImageTintColor(colorInt)
}
