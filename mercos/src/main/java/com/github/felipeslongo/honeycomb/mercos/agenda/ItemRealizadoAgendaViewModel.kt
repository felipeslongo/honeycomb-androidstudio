package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ItemRealizadoAgendaViewModel {

    private val _descricaoDoResultado = MutableLiveData("")

    val descricaoDoResultado: LiveData<String> = _descricaoDoResultado
    val sumario : ItemSumarioAgendaViewModel = ItemSumarioAgendaViewModel()

    fun atualizarViewState(viewState: ItemRealizadoAgendaViewState?) {
        if (viewState == null) {
            atualizarEstadoParaPlaceholder()
            return
        }
        sumario.atualizarViewState(viewState.sumario)
        _descricaoDoResultado.value = viewState.descricaoDoResultado
    }

    fun atualizarEstadoParaPlaceholder() {
        sumario.atualizarEstadoParaPlaceholder()
    }
}