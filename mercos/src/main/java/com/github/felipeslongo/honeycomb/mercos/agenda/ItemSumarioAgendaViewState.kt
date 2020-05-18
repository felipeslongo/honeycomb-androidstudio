package com.github.felipeslongo.honeycomb.mercos.agenda

data class ItemSumarioAgendaViewState(
    val id: Int,
    val tipo: TiposDeEventoEnum = TiposDeEventoEnum.OUTROS,
    val nomeDoCliente: String = "",
    val nomeDoRoteiro: String = "",
    val horario: String = "",
    val nomeDoResponsavel: String = "",
    val telefone: String = "",
    val endereco: String = ""
) {

    companion object {
        fun createLoremIpsum(id: Int) = ItemSumarioAgendaViewState(
            id,
            TiposDeEventoEnum.OUTROS,
            "Lima Luminárias e Acessórios",
            "Rota Zona Sul",
            "15:32",
            "João Martins",
            "9 8874-1218",
            "Rua Benjamin Constant, 9876"
        )
    }
}