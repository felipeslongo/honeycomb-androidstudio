package com.example.honeycomb.ui.navigationViews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.R
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import com.google.android.material.switchmaterial.SwitchMaterial


class NavigationViewShowcaseActivity : AppCompatActivity() {

    private val LogTag: String = NavigationViewShowcaseActivity::class.java.toString()

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

        val item = navigationView.menu
            .findItem(R.id.navigation_view_showcase_checkable_behavior_actions_switch)
            .actionView as SwitchMaterial
        item.setOnCheckedChangeListener { _, isChecked ->
            val msg = "onCheckedChanged$isChecked"
            Log.v(LogTag, msg)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

}
