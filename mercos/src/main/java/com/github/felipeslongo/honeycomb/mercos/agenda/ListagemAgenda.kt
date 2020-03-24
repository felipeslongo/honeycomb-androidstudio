package com.github.felipeslongo.honeycomb.mercos.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.felipeslongo.honeycomb.mercos.R

class ListagemAgenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_agenda)
    }

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, ListagemAgenda::class.java))
        }
    }
}