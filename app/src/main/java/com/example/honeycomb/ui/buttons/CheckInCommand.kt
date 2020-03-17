package com.example.honeycomb.ui.buttons

import androidx.lifecycle.LiveData
import com.example.honeycomb.ui.mvvm.Command

class CheckInCommand(
    override val canExecute: LiveData<Boolean>,
    val checkOut: () -> Unit) : Command {
    override fun execute(args: Any) = checkOut()
}