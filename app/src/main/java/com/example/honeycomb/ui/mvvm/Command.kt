package com.example.honeycomb.ui.mvvm

import androidx.lifecycle.LiveData

//https://github.com/xamarin/Xamarin.Forms/blob/master/Xamarin.Forms.Core/Command.cs
interface Command {
    val canExecute: LiveData<Boolean>
    fun execute(args: Any)
}