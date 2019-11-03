package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.honeycomb.ui.mvvm.Command

class CheckOutCommand(
    override val canExecute: LiveData<Boolean>,
    val checkIn: () -> Unit) : Command {
    override fun execute(args: Any) = checkIn()
}