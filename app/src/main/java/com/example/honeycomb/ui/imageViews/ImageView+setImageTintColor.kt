package com.example.honeycomb.ui.imageViews

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

fun ImageView.setImageTintColorWithAnotherViewBackgroundColor(anotherView: ViewParent){
    val asView = anotherView as View? ?: return
    setImageTintColorWithAnotherViewBackgroundColor(asView)
}

fun ImageView.setImageTintColorWithAnotherViewBackgroundColor(anotherView: View){
    val colorDrawable = anotherView.background as ColorDrawable? ?: return
    setImageTintColor(colorDrawable.color)
}

fun ImageView.setImageTintColor(colorId: Int){
    val tint = ColorStateList.valueOf(colorId)
    ImageViewCompat.setImageTintList(this, tint)
}