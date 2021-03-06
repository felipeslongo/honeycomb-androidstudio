package com.example.honeycomb.ui.chips

import android.os.Build
import android.util.Log
import android.view.*
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.widget.PopupWindowCompat
import com.example.honeycomb.R
import com.google.android.material.chip.*

fun Chip.showExpandable(layoutInflater: LayoutInflater, closeClicked: () -> Unit) : PopupWindow {
    return this.showExpandable(layoutInflater, R.layout.chip_expandable, closeClicked)
}

fun Chip.showExpandable(layoutInflater: LayoutInflater, layoutId: Int, closeClicked: () -> Unit) : PopupWindow {

    var view = layoutInflater.inflate(layoutId, null)
    var allowTapOutsideToDismiss = true
    var popupWindow = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, allowTapOutsideToDismiss)

    // Set an elevation value for popup window
    // Call requires API level 21
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        popupWindow.elevation = 25.0f
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        popupWindow.overlapAnchor = true
    }

    view.setOnTouchListener { v, event ->
        popupWindow.dismiss()
        true
    }
    view.findViewById<View>(R.id.chip_expandable_close).setOnClickListener {
        closeClicked()
        popupWindow.dismiss()
    }
    view.findViewById<TextView>(R.id.chip_expandable_text).text = this.text

    try {
        popupWindow.showAsDropDown(this, 0, 0, Gravity.CENTER)
    }catch (e: WindowManager.BadTokenException){
        //android.view.WindowManager$BadTokenException: Unable to add window -- token null is not valid; is your activity running?
        Log.e("Chip.showExpandable", "Ensure you call this method after your activity gets started and running, because there is no window", e)
        throw e
    }

    return popupWindow
}