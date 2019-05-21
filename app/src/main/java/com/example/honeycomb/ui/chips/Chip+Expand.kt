package com.example.honeycomb.ui.chips

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.google.android.material.chip.*

fun Chip.showExpandable(layoutInflater: LayoutInflater, layoutId: Int) : PopupWindow {

    var view = layoutInflater.inflate(layoutId, null)
    var popupWindow = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    // Set an elevation value for popup window
    // Call requires API level 21
    if(Build.VERSION.SDK_INT>=21){
        popupWindow.elevation = 5.0f
    }

    popupWindow.showAsDropDown(this)
    return popupWindow
}