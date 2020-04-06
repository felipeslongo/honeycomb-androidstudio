package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ItemSumarioAgendaViewModel {
    val _nomeDoCliente: MutableLiveData<String> = MutableLiveData("")
    val _nomeDoRoteiro: MutableLiveData<String> = MutableLiveData("")
    val _horario: MutableLiveData<String> = MutableLiveData("")
    val _nomeDoResponsavel: MutableLiveData<String> = MutableLiveData("")
    val _telefone: MutableLiveData<String> = MutableLiveData("")
    val _endereco: MutableLiveData<String> = MutableLiveData("")

    val nomeDoCliente: LiveData<String> = _nomeDoCliente
    val nomeDoRoteiro: LiveData<String> = _nomeDoRoteiro
    val horario: LiveData<String> = _horario
    val nomeDoResponsavel: LiveData<String> = _nomeDoResponsavel
    val telefone: LiveData<String> = _telefone
    val endereco: LiveData<String> = _endereco

    fun atualizarViewState(viewState: ItemSumarioAgendaViewState?) {
        if (viewState == null) {
            atualizarEstadoParaPlaceholder()
            return
        }
        _nomeDoCliente.value = viewState.nomeDoCliente
        _nomeDoRoteiro.value = viewState.nomeDoRoteiro
        _horario.value = viewState.horario
        _nomeDoResponsavel.value = viewState.nomeDoResponsavel
        _telefone.value = viewState.telefone
        _endereco.value = viewState.endereco
    }

    fun atualizarEstadoParaPlaceholder() {
        _nomeDoCliente.value = ""
        _nomeDoRoteiro.value = ""
        _horario.value = ""
        _nomeDoResponsavel.value = ""
        _telefone.value = ""
        _endereco.value = ""
    }
}