package com.example.honeycomb.ui.progressBars

import android.view.View
import com.example.honeycomb.databinding.ProgressoSucessoErroBinding

class ProgressoSucessoErroView(val binding: ProgressoSucessoErroBinding) {

    fun notificarProgresso(){
        binding.progressoSucessoErro.displayedChild = INDICE_PROGRESSO
    }

    fun notificarSucesso(){
        binding.progressoSucessoErro.displayedChild = INDICE_SUCESSO
    }

    fun notificarErro(){
        binding.progressoSucessoErro.displayedChild = INDICE_ERRO
    }

    companion object{
        private const val INDICE_PROGRESSO: Int = 0
        private const val INDICE_SUCESSO: Int = 1
        private const val INDICE_ERRO: Int = 2

        fun create(root: View) : ProgressoSucessoErroView{
            val binding = ProgressoSucessoErroBinding.bind(root)
            return ProgressoSucessoErroView(binding)
        }

        fun create(binding: ProgressoSucessoErroBinding) : ProgressoSucessoErroView{
            return ProgressoSucessoErroView(binding)
        }
    }
}