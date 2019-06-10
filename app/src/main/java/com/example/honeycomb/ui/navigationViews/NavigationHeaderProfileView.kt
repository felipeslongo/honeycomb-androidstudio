package com.example.honeycomb.ui.navigationViews

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.honeycomb.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.navigation_header_profile.view.*

class NavigationHeaderProfileView private constructor(navigationView: NavigationView) {
    private val profilesView: AppCompatImageButton
    private val emailView: AppCompatTextView
    private val usernameView: AppCompatTextView

    companion object{
        val LayoutId = R.layout.navigation_header_profile

        fun create(navigationView: NavigationView) : NavigationHeaderProfileView{
            return NavigationHeaderProfileView(navigationView)
        }
    }
        init {
            val header = navigationView.getHeaderView(0)
            usernameView = header.navigation_header_profile_username
            emailView = header.navigation_header_profile_email
            profilesView = header.navigation_header_profile_profiles
        }
}