package com.github.felipeslongo.honeycomb.mercos.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentListagemAgendaBinding
import honeycomb.platform.android.lifecycle.getViewModel

class ListagemAgenda : AppCompatActivity() {

    val viewModel by lazy { getViewModel { ListagemAgendaAndroidViewModel() } }
    val viewBinding by lazy {
        val binding = ContentListagemAgendaBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return@lazy binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, ListagemAgenda::class.java))
        }
    }
}