package com.github.felipeslongo.honeycomb.mercos.agenda

data class ItemRealizadoAgendaViewState(
    val sumario: ItemSumarioAgendaViewState,
    val descricaoDoResultado: String = ""
) {
    companion object {
        fun createLoremIpsum(id: Int) = ItemRealizadoAgendaViewState(
            ItemSumarioAgendaViewState.createLoremIpsum(id),
            if(id % 2 == 0) "Descrição do Resultado do Atendimento" else "What is your attitude as a small town businessman when it comes to advertising or taking help of an advertising design agency to provide creative desig…"
        )
    }
}