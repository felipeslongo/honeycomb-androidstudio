package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListagemAgendaAndroidViewModel : ViewModel() {
    private val _itens: MutableLiveData<List<ItemAgendaViewState>> =
        MutableLiveData(listOf())
    private var initAsyncJob: Job

    init {
        initAsyncJob = initAsync()
    }

    val itens: LiveData<List<ItemAgendaViewState>> = _itens

    private fun initAsync() = viewModelScope.launch {
        loadDataAsync()
    }

    private suspend fun loadDataAsync() {
        delay(3000)
        val newItens = mutableListOf<ItemAgendaViewState>()
        for (index in 1..1000)
            newItens.add(ItemAgendaViewState.createLoremIpsum(index))
        _itens.value = newItens
    }
}