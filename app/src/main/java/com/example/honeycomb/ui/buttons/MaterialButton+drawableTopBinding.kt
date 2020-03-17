package com.example.honeycomb.ui.buttons

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton

@BindingAdapter("app:drawableTopBinding")
fun drawableTopBinding(button: MaterialButton, drawableId: Int){

    button.setCompoundDrawablesWithIntrinsicBounds(0, drawableId,0,0)
}

@BindingAdapter("app:drawableTopBinding")
fun drawableTopBinding(button: MaterialButton, drawable: Drawable){

    button.setCompoundDrawablesWithIntrinsicBounds(null, drawable,null,null)
}