package com.example.honeycomb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.ui.chips.ExpandableChipShowcaseFragment
import com.example.honeycomb.ui.main.MainFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

            findViewById<NavigationView>(R.id.main_navigation).setNavigationItemSelectedListener {
                if (it.itemId == R.id.maind_navigation_item_chips_expandable) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ExpandableChipShowcaseFragment.newInstance())
                        .commitNow()
                }

                findViewById<DrawerLayout>(R.id.main_drawer).closeDrawers()
                true
            }
        }
    }

}
