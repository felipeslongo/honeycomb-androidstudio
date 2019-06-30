package com.example.honeycomb.ui.identity

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.example.honeycomb.databinding.ProfileViewBinding
import com.example.honeycomb.ui.imageViews.AvatarView

class ProfileView {
    private lateinit var rootView: ViewGroup
    private lateinit var nameView: AppCompatTextView
    private lateinit var emailView: AppCompatTextView
    private lateinit var avatarView: AvatarView

    var avatarDrawable: Drawable
        get() = avatarView.drawable
        set(value) {avatarView.drawable = value}

    var name: String
        get() = nameView.text.toString()
        set(value) {nameView.text = value}

    var email: String
        get() = emailView.text.toString()
        set(value) {emailView.text = value}

    fun asView() : View{
        return rootView
    }

    private fun refreshAvatarViewBackground(){
        avatarView.refreshBackground()
    }

    companion object{
        fun inflate (inflater: LayoutInflater) : ProfileView {
            return inflate(inflater, null)
        }

        fun inflate (inflater: LayoutInflater, parent: ViewGroup?) : ProfileView{
            val binding = ProfileViewBinding.inflate(inflater, parent, false)
            val view = ProfileView()
            view.rootView = binding.root as ViewGroup
            view.nameView = binding.name
            view.emailView = binding.email
            view.avatarView = AvatarView.create(binding.avatar)
            view.refreshAvatarViewBackground()

            return view
        }
    }
}