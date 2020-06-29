package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemProgramadoAgendaBinding

class ListagemAgendaProgramadosViewHolder(
    lifecycleOwner: LifecycleOwner,
    val viewBinding: ViewItemProgramadoAgendaBinding
) :
    RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.lifecycleOwner = lifecycleOwner
        viewBinding.viewModel =
            ItemProgramadoAgendaAndroidViewModel().apply { this.atualizarEstadoParaPlaceholder() }
        viewBinding.cardView.setOnClickListener { DetalheAgenda.present(viewBinding.root.context) }
    }

    val viewModel: ItemProgramadoAgendaAndroidViewModel
        get() {
            return viewBinding.viewModel
                ?: throw IllegalStateException("ViewBinding ViewModel is Null")
        }
}
