package com.github.felipeslongo.honeycomb.mercos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CampoDetalheViewModel(nome: String, valor: String = "") {

    private val _nome : MutableLiveData<String> = MutableLiveData(nome)
    private val _valor : MutableLiveData<String> = MutableLiveData(valor)

    val nome : LiveData<String> = _nome
    val valor : LiveData<String> = _valor
}