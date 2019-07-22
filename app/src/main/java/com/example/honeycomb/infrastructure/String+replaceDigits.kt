package com.example.honeycomb.infrastructure

fun String.replaceDigits(placeholder: String): String{
    val regex = Regex("[0-9]")
    return regex.replace(this, placeholder)
}