package com.example.honeycomb.ui.imageViews

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.honeycomb.databinding.ViewAvatarBinding


class AvatarView(private val binding: ViewAvatarBinding) {

    companion object{
        fun create(inflater: LayoutInflater) : AvatarView{
            val binding = ViewAvatarBinding.inflate(inflater)
            return create(binding)
        }

        fun create(inflater: LayoutInflater, parent: ViewGroup) : AvatarView{
            val binding = ViewAvatarBinding.inflate(inflater, parent, false)
            return create(binding)
        }

        fun create(binding: ViewAvatarBinding) : AvatarView{
            return AvatarView(binding)
        }
    }

    var drawable: Drawable
        get() = binding.avatar.drawable
        set(value) {
            binding.avatar.setImageDrawable(value)
        }
}