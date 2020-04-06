package com.github.felipeslongo.honeycomb.mercos.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemProgramadoAgendaBinding

class ListagemAgendaProgramadosAdapter(
    val lifecycleOwner: LifecycleOwner,
    val viewModel: ListagemAgendaAndroidViewModel
) : RecyclerView.Adapter<ListagemAgendaProgramadosViewHolder>() {

    private val itens: MutableList<ItemProgramadoAgendaViewState> = mutableListOf()

    init {
        viewModel.itensProgramados.observe(lifecycleOwner, Observer { newItens ->
            itens.clear()
            itens.addAll(newItens)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListagemAgendaProgramadosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewItemProgramadoAgendaBinding.inflate(inflater, parent, false)
        return ListagemAgendaProgramadosViewHolder(lifecycleOwner, viewBinding)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ListagemAgendaProgramadosViewHolder, position: Int) {
        holder.viewModel.atualizarViewState(itens.getOrNull(position))
    }
}