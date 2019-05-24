package com.example.honeycomb.ui.viewGroups

import android.view.View
import android.view.ViewGroup

fun ViewGroup.addViewBefore(view: View, anchorView: View){
    val anchorIndex = this.indexOfChild(anchorView)
    if(anchorIndex == -1)
        throw Exception("View Not Found")

    val beforeIndex = this.indexOfChild(anchorView) - 1
    if(beforeIndex < 0)
        this.addView(view)

    this.addView(view, beforeIndex)
}