package com.example.honeycomb.kotlin.coroutines

import com.example.honeycomb.infrastructure.ThreadServices

class CoroutineLogger {
    companion object {
        fun printlnStart(message: String){
            kotlin.io.println("-${message}--- start: ${ThreadServices.name}")
        }

        fun printlnEnd(message: String){
            kotlin.io.println("-${message}--- ended: ${ThreadServices.name}")
        }

        fun println(message: String){
            kotlin.io.println("-${message}---: ${ThreadServices.name}")
        }
    }
}