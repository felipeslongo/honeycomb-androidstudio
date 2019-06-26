package com.example.honeycomb.ui.googlePlay

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.RecyclerView
import com.example.honeycomb.R

class SincronizacaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun popular(item: SincronizacaoItem) {
        val nomeView = itemView.findViewById<TextView>(R.id.sincronizacao_item_model_nome)
        val descricaoView = itemView.findViewById<TextView>(R.id.sincronizacao_item_model_descricao)
        val iconeView = itemView.findViewById<ImageView>(R.id.sincronizacao_item_model_icone)
        val statusView = itemView.findViewById<ViewFlipper>(R.id.sincronizacao_item_model_status)

        nomeView.text = item.nome
        descricaoView.text = item.descricao
        iconeView.setImageResource(item.icone)

        statusView.displayedChild = item.status.ordinal
    }

}