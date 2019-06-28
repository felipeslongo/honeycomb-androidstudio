package com.example.honeycomb.ui.imageViews

import android.graphics.drawable.Drawable
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.example.honeycomb.databinding.ViewAvatarBinding

class AvatarView(private val avatarView: AppCompatImageView) {

    companion object{
        fun create(binding: ViewAvatarBinding) : AvatarView{
            return AvatarView(binding.avatar)
        }

        fun create(avatarView: AppCompatImageView) : AvatarView{
            return AvatarView(avatarView)
        }

        fun createWithBinding(rootView: View) : AvatarView{
            val binding = ViewAvatarBinding.bind(rootView)
            return create(binding)
        }
    }

    var drawable: Drawable
        get() = avatarView.drawable
        set(value) {
            avatarView.setImageDrawable(value)
        }
}