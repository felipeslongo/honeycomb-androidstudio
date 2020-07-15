package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.github.felipeslongo.honeycomb.mercos.R

class ItemSumarioAgendaViewModel {
    val _tipo: MutableLiveData<TiposDeEventoEnum> = MutableLiveData(TiposDeEventoEnum.OUTROS)
    val _nomeDoCliente: MutableLiveData<String> = MutableLiveData("")
    val _nomeDoRoteiro: MutableLiveData<String> = MutableLiveData("")
    val _horario: MutableLiveData<String> = MutableLiveData("")
    val _nomeDoResponsavel: MutableLiveData<String> = MutableLiveData("")
    val _telefone: MutableLiveData<String> = MutableLiveData("")
    val _endereco: MutableLiveData<String> = MutableLiveData("")

    val tipo: LiveData<TiposDeEventoEnum> = _tipo
    val nomeDoCliente: LiveData<String> = _nomeDoCliente
    val nomeDoRoteiro: LiveData<String> = _nomeDoRoteiro
    val horario: LiveData<String> = _horario
    val nomeDoResponsavel: LiveData<String> = _nomeDoResponsavel
    val telefone: LiveData<String> = _telefone
    val endereco: LiveData<String> = _endereco

    val iconeDoTipo : LiveData<Int> = Transformations.map(tipo){
        when {
            it > TiposDeEventoEnum.VISITA -> R.drawable.ic_baseline_location_on_24
            it > TiposDeEventoEnum.LIGACAO -> R.drawable.ic_baseline_call_24
            it > TiposDeEventoEnum.EMAIL -> R.drawable.ic_baseline_email_24
            it > TiposDeEventoEnum.WHATSAPP -> R.drawable.ic_whatsapp_24
            it > TiposDeEventoEnum.SKYPE -> R.drawable.ic_skype_24
            else -> R.drawable.ic_baseline_assignment_24
        }
    }

    fun atualizarViewState(viewState: ItemSumarioAgendaViewState?) {
        if (viewState == null) {
            atualizarEstadoParaPlaceholder()
            return
        }
        _tipo.value = viewState.tipo
        _nomeDoCliente.value = viewState.nomeDoCliente
        _nomeDoRoteiro.value = viewState.nomeDoRoteiro
        _horario.value = viewState.horario
        _nomeDoResponsavel.value = viewState.nomeDoResponsavel
        _telefone.value = viewState.telefone
        _endereco.value = viewState.endereco
    }

    fun atualizarEstadoParaPlaceholder() {
        _tipo.value = TiposDeEventoEnum.OUTROS
        _nomeDoCliente.value = ""
        _nomeDoRoteiro.value = ""
        _horario.value = ""
        _nomeDoResponsavel.value = ""
        _telefone.value = ""
        _endereco.value = ""
    }
}