package com.example.honeycomb.ui.navigationViews

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.honeycomb.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.navigation_header_profile.view.*

class NavigationHeaderProfileView private constructor(navigationView: NavigationView) {
    private lateinit var profilesToggledListener: (isOpen: Boolean) -> Unit
    private val profilesToggleView: AppCompatImageButton
    private val emailView: AppCompatTextView
    private val usernameView: AppCompatTextView

    private var profilesIsOpen = false

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
        profilesToggleView = header.navigation_header_profile_profiles

        bindListeners()
    }

    private fun bindListeners() {
        profilesToggleView.setOnClickListener {
            profilesIsOpen = !profilesIsOpen
            profilesToggledListener(profilesIsOpen)
        }
    }

    fun setOnProfilesToggledListener(listener: (isOpen: Boolean) -> Unit){
        profilesToggledListener = listener
    }
}