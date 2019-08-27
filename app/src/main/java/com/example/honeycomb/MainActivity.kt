package com.example.honeycomb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.ui.badges.BadgeShowcaseFragment
import com.example.honeycomb.ui.chips.ExpandableChipShowcaseFragment
import com.example.honeycomb.ui.chips.GmailInputChipsShowcaseFragment
import com.example.honeycomb.ui.dataBindings.AndroidDataBindingCodelabActivity
import com.example.honeycomb.ui.imageViews.CircleImageShowcaseFragment
import com.example.honeycomb.ui.main.MainFragment
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity
import com.example.honeycomb.ui.sync.SincronizacaoFragment
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

                if (it.itemId == R.id.main_navigation_item_gmail_input_chips_showcase_fragment) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, GmailInputChipsShowcaseFragment.newInstance())
                        .commitNow()
                }

                if (it.itemId == R.id.main_navigation_item_circle_image_showcase) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CircleImageShowcaseFragment.newInstance())
                        .commitNow()
                }

                if (it.itemId == R.id.main_navigation_item_navigation_view_showcase) {
                    NavigationViewShowcaseActivity.present(this)
                }

                if (it.itemId == R.id.main_navigation_item_android_databinding_codelab) {
                    AndroidDataBindingCodelabActivity.present(this)
                }

                if (it.itemId == R.id.sincronizacao) {
                    SincronizacaoFragment.apresentar(this)
                }

                if (it.itemId == R.id.badge) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BadgeShowcaseFragment.newInstance())
                        .commitNow()
                }

                findViewById<DrawerLayout>(R.id.main_drawer).closeDrawers()
                true
            }
        }
    }

}
