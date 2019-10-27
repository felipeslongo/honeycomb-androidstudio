package com.example.honeycomb.ui.workmanager

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class CodelabsWorkManagerFragment : Fragment() {

    companion object {
        fun newInstance() = CodelabsWorkManagerFragment()
    }

    private lateinit var viewModel: CodelabsWorkManagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.codelabs_workmanager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CodelabsWorkManagerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
