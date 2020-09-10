package com.github.felipeslongo.honeycomb.mercos.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.felipeslongo.honeycomb.mercos.R
import honeycomb.platform.android.lifecycle.getViewModel

class ItensRealizadosAgendaFragment : Fragment() {

    lateinit var viewModel: ListagemAgendaAndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_itens_realizados_agenda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = requireActivity().getViewModel{ ListagemAgendaAndroidViewModel() }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.recyclerView_realizados)
        recyclerView.adapter = ListagemAgendaRealizadosAdapter(this, viewModel)
    }

    companion object {
        fun newInstance() = ItensRealizadosAgendaFragment()
    }
}