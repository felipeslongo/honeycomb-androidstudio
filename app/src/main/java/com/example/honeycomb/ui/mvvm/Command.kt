package com.example.honeycomb.ui.mvvm

import androidx.lifecycle.LiveData

interface Command {
    val canExecuteChanged: LiveData<Unit>
    fun canExecute(args: Any) : Boolean
    fun execute(args: Any)
}