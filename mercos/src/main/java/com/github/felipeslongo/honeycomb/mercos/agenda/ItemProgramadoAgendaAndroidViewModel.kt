package com.github.felipeslongo.honeycomb.mercos.agenda

class ItemProgramadoAgendaAndroidViewModel {
    val sumario : ItemSumarioAgendaViewModel = ItemSumarioAgendaViewModel()

    fun atualizarViewState(viewState: ItemProgramadoAgendaViewState?) {
        if (viewState == null) {
            atualizarEstadoParaPlaceholder()
            return
        }
        sumario.atualizarViewState(viewState.sumario)
    }

    fun atualizarEstadoParaPlaceholder() {
        sumario.atualizarEstadoParaPlaceholder()
    }
}