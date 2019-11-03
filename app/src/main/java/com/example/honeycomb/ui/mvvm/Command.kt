package com.example.honeycomb.ui.mvvm

import androidx.lifecycle.LiveData

interface Command {
    val canExecute: LiveData<Boolean>
    fun execute(args: Any)
}