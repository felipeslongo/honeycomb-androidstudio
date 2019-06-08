package com.example.honeycomb.ui.navigationViews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.R
import com.google.android.material.navigation.NavigationView

class NavigationViewShowcaseActivity : AppCompatActivity() {

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
        val navigationView = findViewById<NavigationView>(R.id.navigation_view_showcase_drawer_navigation)
        navigationView.setNavigationItemSelectedListener {menuItem: MenuItem ->
            menuItem.isChecked = true
            drawer.closeDrawers()
            true
        }
    }
}
