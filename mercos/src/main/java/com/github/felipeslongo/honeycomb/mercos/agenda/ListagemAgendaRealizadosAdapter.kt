package com.github.felipeslongo.honeycomb.mercos.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemProgramadoAgendaBinding
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemRealizadoAgendaBinding

class ListagemAgendaRealizadosAdapter(
    val lifecycleOwner: LifecycleOwner,
    val viewModel: ListagemAgendaAndroidViewModel
) : RecyclerView.Adapter<ListagemAgendaRealizadosViewHolder>() {

    private val itens: MutableList<ItemRealizadoAgendaViewState> = mutableListOf()

    init {
        viewModel.itensRealizados.observe(lifecycleOwner, Observer { newItens ->
            itens.clear()
            itens.addAll(newItens)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListagemAgendaRealizadosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewItemRealizadoAgendaBinding.inflate(inflater, parent, false)
        return ListagemAgendaRealizadosViewHolder(lifecycleOwner, viewBinding)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ListagemAgendaRealizadosViewHolder, position: Int) {
        holder.viewModel.atualizarViewState(itens.getOrNull(position))
    }
}