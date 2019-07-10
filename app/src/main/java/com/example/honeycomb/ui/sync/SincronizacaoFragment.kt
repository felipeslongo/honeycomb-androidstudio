package com.example.honeycomb.ui.sync

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ProgressoSucessoErroBinding
import com.example.honeycomb.databinding.SincronizacaoCompletaBinding
import com.example.honeycomb.ui.progressBars.ProgressoSucessoErroView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class SincronizacaoFragment : DialogFragment() {

    private lateinit var binding: SincronizacaoCompletaBinding
    private var mostrarDetalhes: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SincronizacaoCompletaBinding.inflate(inflater, container, false)
        impedirCancelamentoDoUsuario()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titulo.text = "Sincronizacao de dados"
        binding.descricao.text = "Estamos preparando o aplicativo para sua utilização. Por favor, aguarde um instante."
        binding.status.text = "Baixando e configurando…"
        binding.tempo.text = "00:00:03"
        binding.progresso.progress = 10

        binding.mostrarDetalhes.setOnClickListener {
            mostrarDetalhes = !mostrarDetalhes
            atualizaMostrarDetalhes()
        }

        binding.tentarNovamente.setOnClickListener {
            iniciarSincronizacao()
        }

        binding.cancelar.setOnClickListener {
            dismiss()
        }

        iniciarSincronizacao()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        removerTitulo(dialog)
        return dialog
    }

    override fun onResume() {
        super.onResume()
        redimensionar()
    }


    private fun removerTitulo(dialog: Dialog) {
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
    }

    private fun redimensionar() {
        if(resources.getBoolean(R.bool.isTablet))
            return

        val window = dialog!!.window!!
        val layoutParams = window.attributes
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        window.attributes = layoutParams
    }

    private fun impedirCancelamentoDoUsuario() {
        isCancelable = false
    }

    private fun atualizaMostrarDetalhes() {
        if (mostrarDetalhes) {
            binding.grupoEntidades.visibility = View.VISIBLE
            binding.mostrarDetalhes.text = "Ocultar detalhes"
        } else {
            binding.grupoEntidades.visibility = View.GONE
            binding.mostrarDetalhes.text = "Mostrar detalhes"
        }
    }

    private fun iniciarSincronizacao() {
        ProgressoSucessoErroView.create(binding.pedidosStatus).notificarProgresso()
        ProgressoSucessoErroView.create(binding.clientesStatus).notificarProgresso()
        ProgressoSucessoErroView.create(binding.produtosStatus).notificarProgresso()
        SincronizacaoProgressoGeralView.create(binding).notificarEmAndamento()
        SincronizacaoProgressoGeralView.create(binding).notificarProgresso(10)

        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            ProgressoSucessoErroView.create(binding.pedidosStatus).notificarErro()
            SincronizacaoProgressoGeralView.create(binding).notificarErro()
            SincronizacaoProgressoGeralView.create(binding).notificarProgresso(40)
            delay(3000)
            ProgressoSucessoErroView.create(binding.clientesStatus).notificarSucesso()
            SincronizacaoProgressoGeralView.create(binding).notificarProgresso(70)
            delay(3000)
            ProgressoSucessoErroView.create(binding.pedidosStatus).notificarSucesso()
            ProgressoSucessoErroView.create(binding.produtosStatus).notificarSucesso()
            SincronizacaoProgressoGeralView.create(binding).notificarSucesso()
            SincronizacaoProgressoGeralView.create(binding).notificarProgresso(100)
        }
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