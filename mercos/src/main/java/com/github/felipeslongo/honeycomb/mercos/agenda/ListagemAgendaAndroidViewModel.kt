package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListagemAgendaAndroidViewModel : ViewModel() {

    private val _abaSelecionada = MutableLiveData(AbaDaListagemAgendaEnum.PROGRAMADOS)
    private val _itensProgramados: MutableLiveData<List<ItemProgramadoAgendaViewState>> =
        MutableLiveData(listOf())
    private val _itensRealizados: MutableLiveData<List<ItemRealizadoAgendaViewState>> =
        MutableLiveData(listOf())
    private var initAsyncJob: Job

    init {
        initAsyncJob = initAsync()
    }

    val abaSelecionada: LiveData<AbaDaListagemAgendaEnum> = _abaSelecionada
    val itensProgramados: LiveData<List<ItemProgramadoAgendaViewState>> = _itensProgramados
    val itensRealizados: LiveData<List<ItemRealizadoAgendaViewState>> = _itensRealizados

    private fun initAsync() = viewModelScope.launch {
        loadDataAsync()
    }

    private suspend fun loadDataAsync() {
        delay(3000)
        val novosItensProgramados = mutableListOf<ItemProgramadoAgendaViewState>()
        val novoItensRealizados = mutableListOf<ItemRealizadoAgendaViewState>()
        for (index in 1..1000){
            novosItensProgramados.add(ItemProgramadoAgendaViewState.createLoremIpsum(index))
            novoItensRealizados.add(ItemRealizadoAgendaViewState.createLoremIpsum(index))
        }
        _itensProgramados.value = novosItensProgramados
        _itensRealizados.value = novoItensRealizados
    }

    fun notificarAbaSelecionada(abaSelecionada: AbaDaListagemAgendaEnum?) {
        _abaSelecionada.value = abaSelecionada
    }
}