package com.example.honeycomb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.honeycomb.ui.chips.ExpandableChipShowcaseFragment
import com.example.honeycomb.ui.chips.GmailInputChipsShowcaseFragment
import com.example.honeycomb.ui.dataBindings.AndroidDataBindingCodelabActivity
import com.example.honeycomb.ui.imageViews.CircleImageShowcaseFragment
import com.example.honeycomb.ui.imageViews.MovingBackgroundShowcaseFragment
import com.example.honeycomb.ui.main.MainFragment
import com.example.honeycomb.ui.main.MainViewModel
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity
import com.example.honeycomb.ui.seekBars.SwipeViewShowcaseFragment
import com.example.honeycomb.ui.sync.SincronizacaoFragment
import com.example.honeycomb.ui.viewBindings.ViewBindingShowcaseFragment
import com.github.felipeslongo.honeycomb.mercos.agenda.ListagemAgenda
import com.google.android.material.navigation.NavigationView
import honeycomb.platform.android.fragment.app.ProgressDialogView
import honeycomb.platform.android.fragment.app.StatusDialogView
import honeycomb.platform.android.lifecycle.getViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by lazy { getViewModel { MainViewModel() } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        ProgressDialogView(this, viewModel.progressDialogViewModel)
        StatusDialogView(this, viewModel.statusDialogViewModel)

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

            if (it.itemId == R.id.view_binding) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ViewBindingShowcaseFragment.newInstance())
                    .commitNow()
            }

            if (it.itemId == R.id.view_movingbackground) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MovingBackgroundShowcaseFragment.newInstance())
                    .commitNow()
            }

            if (it.itemId == R.id.view_swipe) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SwipeViewShowcaseFragment.newInstance())
                    .commitNow()
            }

            if (it.itemId == R.id.view_dialog_progress) {
                viewModel.progressDialogViewModel.present()
                viewModel.progressDialogViewModel.dismissAfter(5000)
            }

            if (it.itemId == R.id.view_dialog_status) {
                viewModel.statusDialogViewModel.present()
            }

            if (it.itemId == R.id.activity_listagem_agenda) {
                ListagemAgenda.present(this)
            }

            findViewById<DrawerLayout>(R.id.main_drawer).closeDrawers()
            true

        }
    }

}
