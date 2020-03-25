package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListagemAgendaAndroidViewModel : ViewModel() {
    private val _itens: MutableLiveData<List<ItemAgendaAndroidViewModel>> =
        MutableLiveData(listOf())
    private var initAsyncJob: Job

    init {
        initAsyncJob = initAsync()
    }

    val itens: LiveData<List<ItemAgendaAndroidViewModel>> = _itens

    private fun initAsync() = viewModelScope.launch {
        loadDataAsync()
    }

    private suspend fun loadDataAsync() {
        delay(3000)
        val newItens = mutableListOf<ItemAgendaAndroidViewModel>()
        for (index in 0..999)
            newItens.add(ItemAgendaAndroidViewModel())
        _itens.value = newItens
    }
}