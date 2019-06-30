package com.example.honeycomb.ui.navigationViews

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.R
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.google.android.material.switchmaterial.SwitchMaterial
import android.graphics.BitmapFactory
import com.example.honeycomb.ui.drawables.DrawableServices
import com.example.honeycomb.ui.identity.ProfileView


class NavigationViewShowcaseActivity : AppCompatActivity() {

    private val LogTag: String = NavigationViewShowcaseActivity::class.java.toString()
    private lateinit var navigationView: NavigationView
    private lateinit var navigationViewItemIconTintList: ColorStateList

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, NavigationViewShowcaseActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view_showcase)
        bindDrawerNavigationView()
    }

    private fun bindDrawerNavigationView() {
        val drawer = findViewById<DrawerLayout>(R.id.navigation_view_showcase_drawer)
        navigationView = findViewById<NavigationView>(R.id.navigation_view_showcase_drawer_navigation)
        navigationViewItemIconTintList = navigationView.itemIconTintList!!

        val headerView = NavigationHeaderProfileView.create(navigationView)
        headerView.setOnProfilesToggledListener {isOpen -> onProfilesToggled(isOpen) }

        navigationView.setNavigationItemSelectedListener {menuItem: MenuItem ->
            menuItem.isChecked = true
            drawer.closeDrawers()
            true
        }

        val item = navigationView.menu
            .findItem(R.id.navigation_view_showcase_checkable_behavior_actions_switch)
            .actionView as SwitchMaterial
        item.setOnCheckedChangeListener { _, isChecked ->
            val msg = "onCheckedChanged$isChecked"
            Log.v(LogTag, msg)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun onProfilesToggled(isOpen: Boolean){
        Toast.makeText(this, "setOnProfilesToggledListener$isOpen", Toast.LENGTH_SHORT).show()

        navigationView.menu.clear()
        if(isOpen){
            navigationView.itemIconTintList = null
            addProfiles(navigationView.menu)
            return
        }

        navigationView.itemIconTintList = navigationViewItemIconTintList
        navigationView.inflateMenu(R.menu.navigation_view_showcase)
    }

    private fun addProfiles(menu: Menu) {
//        val profile = menu.add("Felipe de Souza Longo")
//        profile.icon = DrawableServices.createAvatar(resources, R.drawable.image_skyward_sword)

        val profile = menu.add(null)
        profile.icon = null
        profile.actionView = ProfileView.inflate(layoutInflater).asView()
    }
}
