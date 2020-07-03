package com.github.felipeslongo.honeycomb.mercos.agenda

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.felipeslongo.honeycomb.mercos.R
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentDetalheAgendaBinding
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentListagemAgendaBinding
import honeycomb.platform.android.lifecycle.getViewModel

class DetalheAgenda : AppCompatActivity() {

    val viewModel by lazy { getViewModel { DetalheAgendaViewModel() } }
    val viewBinding by lazy {
        val binding = ContentDetalheAgendaBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.executePendingBindings()
        return@lazy binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolbar)
        initBindings()
    }

    private fun initBindings() {
        viewBinding.detalhes.viewModel = viewModel.detalhes
        viewBinding.detalhes.executePendingBindings()

        viewBinding.cliente.viewModel = viewModel.cliente
        viewBinding.cliente.executePendingBindings()

        viewBinding.cnpj.viewModel = viewModel.cnpj
        viewBinding.cnpj.executePendingBindings()

        viewBinding.responsavel.viewModel = viewModel.responsavel
        viewBinding.responsavel.executePendingBindings()

        viewBinding.tipo.viewModel = viewModel.tipo
        viewBinding.tipo.executePendingBindings()

        viewBinding.roteiro.viewModel = viewModel.roteiro
        viewBinding.roteiro.executePendingBindings()

        viewBinding.telefone.viewModel = viewModel.telefone
        viewBinding.telefone.executePendingBindings()

        viewBinding.endereco.viewModel = viewModel.endereco
        viewBinding.endereco.executePendingBindings()
    }

    companion object {
        fun present(context: Context) {
            context.startActivity(Intent(context, DetalheAgenda::class.java))
        }
    }
}