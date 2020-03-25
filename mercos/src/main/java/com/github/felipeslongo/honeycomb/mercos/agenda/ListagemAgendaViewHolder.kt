package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemAgendaBinding

class ListagemAgendaViewHolder(
    lifecycleOwner: LifecycleOwner,
    val viewBinding: ViewItemAgendaBinding
) :
    RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.lifecycleOwner = lifecycleOwner
        viewBinding.viewModel =
            ItemAgendaAndroidViewModel().apply { this.atualizarEstadoParaPlaceholder() }
    }

    val viewModel: ItemAgendaAndroidViewModel
        get() {
            return viewBinding.viewModel
                ?: throw IllegalStateException("ViewBinding ViewModel is Null")
        }
}
