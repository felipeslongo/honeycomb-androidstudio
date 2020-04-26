package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemProgramadoAgendaBinding
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemRealizadoAgendaBinding

class ListagemAgendaRealizadosViewHolder(
    lifecycleOwner: LifecycleOwner,
    val viewBinding: ViewItemRealizadoAgendaBinding
) :
    RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.lifecycleOwner = lifecycleOwner
        viewBinding.viewModel =
            ItemRealizadoAgendaViewModel().apply { this.atualizarEstadoParaPlaceholder() }
    }

    val viewModel: ItemRealizadoAgendaViewModel
        get() {
            return viewBinding.viewModel
                ?: throw IllegalStateException("ViewBinding ViewModel is Null")
        }
}
