package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.ViewModel
import com.github.felipeslongo.honeycomb.mercos.ui.CampoDetalheViewModel

class DetalheAgendaViewModel : ViewModel() {

    val detalhes = CampoDetalheViewModel("Detalhes", "Cliente prefere fazer pedidos 10 dias antes do fechamento. Agendar visitas também próximo a estes dias.")
    val cliente = CampoDetalheViewModel("Cliente", "Lima Luminárias e Acessórios")
    val cnpj = CampoDetalheViewModel("CNPJ", "08.808.295/0001-39")
    val responsavel = CampoDetalheViewModel("Responsável", "João Martins")
    val tipo = CampoDetalheViewModel("Tipo", "Visita")
    val roteiro = CampoDetalheViewModel("Roteiro", "Rota Zona Sul")
    val telefone = CampoDetalheViewModel("Telefone", "47 2222-2222")
    val endereco = CampoDetalheViewModel("Endereço Principal", "Av. Rolf Wiest, 277\n" +
            "7o andar\n" +
            "Bom Retiro, Joinville, SC\n" +
            "89223-005")
}