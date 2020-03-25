package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.databinding.ViewItemAgendaBinding

class ListagemAgendaViewHolder(val viewBinding: ViewItemAgendaBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    var viewModel: ItemAgendaAndroidViewModel
        get() = viewBinding.viewModel
            ?: throw IllegalStateException("ViewBinding ViewModel is Null")
        set(value) {
            viewBinding.viewModel = value
            viewBinding.executePendingBindings()
        }
}
