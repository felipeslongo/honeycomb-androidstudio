package com.github.felipeslongo.honeycomb.mercos.agenda

import honeycomb.kotlin.EnumCompanion

enum class TiposDeEventoEnum(val value: Int) {
    VISITA(1),
    LIGACAO(2),
    OUTROS(3),
    EMAIL(4),
    WHATSAPP(5),
    SKYPE(6);

    companion object : EnumCompanion<Int, TiposDeEventoEnum>(values().associateBy(TiposDeEventoEnum::value))
}