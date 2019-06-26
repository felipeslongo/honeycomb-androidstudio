package com.example.honeycomb.ui.googlePlay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.honeycomb.R
import com.example.honeycomb.ui.dataBindings.AndroidDataBindingCodelabViewModel
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity

class SincronizacaoActivity : AppCompatActivity() {

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, SincronizacaoActivity::class.java))
        }
    }

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SincronizacaoViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sincronizacao)

        inicializarRecyclerView()
    }

    private fun inicializarRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.sincronizacao_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)


        recyclerView.adapter = SincronizacaoAdapter(viewModel.itens)
    }
}
