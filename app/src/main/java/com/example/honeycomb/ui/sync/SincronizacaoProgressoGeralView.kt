package com.example.honeycomb.ui.sync

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.example.honeycomb.databinding.SincronizacaoCompletaBinding
import android.animation.ObjectAnimator
import android.view.animation.LinearInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import kotlinx.coroutines.*


class SincronizacaoProgressoGeralView(val status: TextView, val tempo: TextView, val progresso: ProgressBar) {

    private var timer: Job? = null

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
        //progresso.progress = progress
    }

    fun notificarEmAndamento(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progresso.progressTintList = ColorStateList.valueOf(Color.MAGENTA)
        }

        status.setTextColor(Color.MAGENTA)
        tempo.setTextColor(Color.MAGENTA)
    }


    fun notificarSucesso(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progresso.progressTintList = ColorStateList.valueOf(Color.GREEN)
        }

        status.setTextColor(Color.GREEN)
        tempo.setTextColor(Color.GREEN)
    }

    fun notificarErro(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progresso.progressTintList = ColorStateList.valueOf(Color.RED)
        }

        status.setTextColor(Color.RED)
        tempo.setTextColor(Color.RED)
    }

    companion object{
        fun create(binding: SincronizacaoCompletaBinding) : SincronizacaoProgressoGeralView{
            return SincronizacaoProgressoGeralView(binding.status, binding.tempo, binding.progresso)
        }
    }
}