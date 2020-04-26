package com.github.felipeslongo.honeycomb.mercos.agenda

data class ItemProgramadoAgendaViewState(
    val sumario: ItemSumarioAgendaViewState
) {

    companion object {
        fun createLoremIpsum(id: Int) = ItemProgramadoAgendaViewState(
            ItemSumarioAgendaViewState.createLoremIpsum(id)
        )
    }
}