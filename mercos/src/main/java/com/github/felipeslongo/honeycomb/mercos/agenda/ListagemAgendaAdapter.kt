package com.github.felipeslongo.honeycomb.mercos.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemAgendaBinding

class ListagemAgendaAdapter(
    val lifecycleOwner: LifecycleOwner,
    val viewModel: ListagemAgendaAndroidViewModel
) : RecyclerView.Adapter<ListagemAgendaViewHolder>() {

    private val itens: MutableList<ItemAgendaViewState> = mutableListOf()

    init {
        viewModel.itens.observe(lifecycleOwner, Observer { newItens ->
            itens.clear()
            itens.addAll(newItens)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListagemAgendaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewItemAgendaBinding.inflate(inflater, parent, false)
        return ListagemAgendaViewHolder(lifecycleOwner, viewBinding)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ListagemAgendaViewHolder, position: Int) {
        holder.viewModel.atualizarViewState(itens.getOrNull(position))
    }
}