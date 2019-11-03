package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.honeycomb.ui.mvvm.Command

class CheckOutCommand(val checkIn: () -> Unit) : Command {
    override val canExecute: LiveData<Boolean> = MutableLiveData(true)

    override fun execute(args: Any) = checkIn()
}