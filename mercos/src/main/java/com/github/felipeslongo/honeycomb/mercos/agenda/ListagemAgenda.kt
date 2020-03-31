package com.github.felipeslongo.honeycomb.mercos.agenda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import com.github.felipeslongo.honeycomb.mercos.R
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentListagemAgendaBinding
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_listagem_agenda, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initRecyclerView() {
        viewBinding.recyclerView.adapter = ListagemAgendaAdapter(this, viewModel)
    }

    companion object {
        fun present(caller: AppCompatActivity) {
            caller.startActivity(Intent(caller, ListagemAgenda::class.java))
        }
    }
}