package com.example.honeycomb.ui.googlePlay

import androidx.lifecycle.ViewModel
import com.example.honeycomb.R

class SincronizacaoViewModel : ViewModel() {
    val itens: List<SincronizacaoItem> = listOf(
        SincronizacaoItem("Pedidos", R.drawable.outline_pregnant_woman_black_36, SincronizacaoStatus.sucesso, "55 minutos"),
        SincronizacaoItem("Clientes", R.drawable.outline_pregnant_woman_black_36, SincronizacaoStatus.erro, "21 minutos"),
        SincronizacaoItem("Tabela de Preço do Produto", R.drawable.outline_pregnant_woman_black_36, SincronizacaoStatus.executando, "21 minutos")
    )
}

data class SincronizacaoItem(
    val nome: String,
    val icone: Int,
    val status: SincronizacaoStatus,
    val descricao: String)

enum class SincronizacaoStatus{
    sucesso,
    erro,
    executando
}

