package com.example.honeycomb.infrastructure

import java.io.PrintStream

class SystemOutListener {

    private val observers: ArrayList<(String) -> Unit> = arrayListOf()

    fun subscribe(observer: (String) -> Unit){
        observers.add(observer)
    }

    fun unsubscribe(observer: (String) -> Unit){
        observers.remove(observer)
    }

    private fun notifyObservers(message: String?){
        if(message.isNullOrEmpty()){
            return
        }

        for (observer in observers){
            observer(message)
        }
    }

    private fun replaceStandardSystemOutPrintStream(){
        System.setOut(PrintLnListener(this))
    }

    companion object{
        val instance: SystemOutListener by lazy {
            val listener = SystemOutListener()
            listener.replaceStandardSystemOutPrintStream()
            listener
        }
    }

    private class PrintLnListener(val systemOutListener: SystemOutListener) : PrintStream(System.out){
        override fun println(x: String?) {
            super.println(x)
            systemOutListener.notifyObservers(x)
        }

        override fun println(x: Int) {
            super.println(x)
            systemOutListener.notifyObservers(x.toString())
        }

        override fun print(s: String?) {
            super.print(s)
            systemOutListener.notifyObservers(s)
        }
    }
}