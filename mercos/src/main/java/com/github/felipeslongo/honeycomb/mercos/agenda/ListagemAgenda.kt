package com.github.felipeslongo.honeycomb.mercos.agenda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.github.felipeslongo.honeycomb.mercos.R
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentListagemAgendaBinding
import com.google.android.material.tabs.TabLayout
import honeycomb.platform.android.lifecycle.getViewModel

class ListagemAgenda : AppCompatActivity() {

    val viewModel by lazy { getViewModel { ListagemAgendaAndroidViewModel() } }
    val viewBinding by lazy {
        val binding = ContentListagemAgendaBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return@lazy binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initRecyclerView()
        initTabLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_listagem_agenda, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initRecyclerView() {
        viewBinding.recyclerViewProgramados.adapter = ListagemAgendaProgramadosAdapter(this, viewModel)
    }

    private fun initTabLayout() {
        viewBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                viewBinding.recyclerViewProgramados.adapter = null
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                initRecyclerView()
            }
        })
    }

    companion object {
        fun present(caller: AppCompatActivity) {
            caller.startActivity(Intent(caller, ListagemAgenda::class.java))
        }
    }
}