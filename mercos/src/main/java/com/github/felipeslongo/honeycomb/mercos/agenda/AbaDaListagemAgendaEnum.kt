package com.github.felipeslongo.honeycomb.mercos.agenda

enum class AbaDaListagemAgendaEnum(val indice: Int) {
    PROGRAMADOS(0),
    REALIZADOS(1);

    companion object {
        private val map = AbaDaListagemAgendaEnum.values().associateBy(AbaDaListagemAgendaEnum::indice)
        fun fromInt(type: Int) = map[type]
    }
}