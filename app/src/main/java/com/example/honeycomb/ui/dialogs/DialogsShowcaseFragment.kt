package com.example.honeycomb.ui.dialogs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R
import com.example.honeycomb.databinding.DialogsShowcaseFragmentBinding

class DialogsShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = DialogsShowcaseFragment()
    }

    private lateinit var viewModel: DialogsShowcaseViewModel
    private lateinit var binding: DialogsShowcaseFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogsShowcaseFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DialogsShowcaseViewModel::class.java)
    }

}
