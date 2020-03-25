package com.github.felipeslongo.honeycomb.mercos.agenda

import androidx.lifecycle.ViewModel

class ItemAgendaAndroidViewModel : ViewModel() {
    companion object {
        val placeholder: ItemAgendaAndroidViewModel by lazy {
            val placeHolderViewModel = ItemAgendaAndroidViewModel()
            return@lazy placeHolderViewModel
        }
    }
}