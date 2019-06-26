package com.example.honeycomb.ui.googlePlay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.honeycomb.R

class SincronizacaoAdapter(val data: List<SincronizacaoItem>) : RecyclerView.Adapter<SincronizacaoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SincronizacaoViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.sincronizacao_item, parent, false)
        return SincronizacaoViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: SincronizacaoViewHolder, position: Int) {
        holder.popular(data[position])
    }
}