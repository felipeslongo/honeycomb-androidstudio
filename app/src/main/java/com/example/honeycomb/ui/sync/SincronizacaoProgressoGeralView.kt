package com.example.honeycomb.ui.sync

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.example.honeycomb.databinding.SincronizacaoCompletaBinding
import android.animation.ObjectAnimator
import android.content.Context
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.example.honeycomb.R
import kotlinx.coroutines.*


class SincronizacaoProgressoGeralView(val status: TextView, val tempo: TextView, val progresso: ProgressBar) {

    private var timer: Job? = null
    private val context: Context by lazy {progresso.context}

    fun iniciarTemporizador(){
        if(timer != null){
            timer!!.cancel()
            timer = null
        }

        tempo.text = "00:00:00"
        timer = criarTimer()
    }

    private fun criarTimer() = GlobalScope.launch(Dispatchers.Main){
        var seconds = 0
        while (true){
            delay(1000)
            seconds++
            var segundos = seconds.toString().padStart(2, '0')
            tempo.text = "00:00:${segundos}"
        }
    }

    fun notificarProgresso(progress: Int){
        val progressAnimator = ObjectAnimator.ofInt(progresso, "progress", progress)
        progressAnimator.duration = 500
        progressAnimator.interpolator = LinearOutSlowInInterpolator()
        progressAnimator.start()
    }

    fun notificarEmAndamento(){
        atribuirCor(R.color.mercos_roxo_900)
    }


    fun notificarSucesso(){
        atribuirCor(R.color.mercos_verde_800)
    }

    fun notificarErro(){
        atribuirCor(R.color.mercos_vermelho)
    }

    private fun atribuirCor(resourceId: Int){
        val color = ContextCompat.getColorStateList(context, resourceId)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progresso.progressTintList = color
        }

        status.setTextColor(color)
        tempo.setTextColor(color)
    }

    companion object{
        fun create(binding: SincronizacaoCompletaBinding) : SincronizacaoProgressoGeralView{
            return SincronizacaoProgressoGeralView(binding.status, binding.tempo, binding.progresso)
        }
    }
}