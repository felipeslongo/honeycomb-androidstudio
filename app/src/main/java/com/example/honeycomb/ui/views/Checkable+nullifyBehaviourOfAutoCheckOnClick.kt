package com.example.honeycomb.ui.views

import android.widget.Checkable

fun Checkable.nullifyBehaviourOfAutoCheckOnClick(){
    isChecked = !isChecked
}
