package com.example.honeycomb.ui.sync

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.honeycomb.R
import com.example.honeycomb.databinding.SincronizacaoCompletaBinding


class SincronizacaoFragment : DialogFragment() {

    private lateinit var binding: SincronizacaoCompletaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SincronizacaoCompletaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titulo.text = "Sincronizacao de dados"
        binding.descricao.text = "Estamos preparando o aplicativo para sua utilização. Por favor, aguarde um instante."
        binding.status.text = "Baixando e configurando…"
        binding.tempo.text = "00:00:03"
        binding.progresso.progress = 10
    }

    companion object{
        private val dialogTag: String = "SincronizacaoFragment"

        fun apresentar(activity: AppCompatActivity) : SincronizacaoFragment{

            val ft = activity.supportFragmentManager.beginTransaction()
            val fragmentoPerdido = activity.supportFragmentManager.findFragmentByTag(dialogTag)
            if (fragmentoPerdido != null)
                ft.remove(fragmentoPerdido)
            ft.addToBackStack(null)

            val dialogFragment = SincronizacaoFragment()
            dialogFragment.show(ft, dialogTag)
            return dialogFragment
        }
    }
}