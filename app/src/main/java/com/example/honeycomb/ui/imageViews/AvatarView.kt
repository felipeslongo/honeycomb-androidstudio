package com.example.honeycomb.ui.imageViews

import android.graphics.drawable.Drawable
import com.example.honeycomb.databinding.ViewAvatarBinding

class AvatarView(private val binding: ViewAvatarBinding) {
    var drawable: Drawable
        get() = binding.avatar.drawable
        set(value) {
            binding.avatar.setImageDrawable(value)
        }
}