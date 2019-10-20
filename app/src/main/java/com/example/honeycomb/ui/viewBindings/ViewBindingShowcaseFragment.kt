package com.example.honeycomb.ui.viewBindings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R
import com.example.honeycomb.databinding.ViewBindingShowcaseFragmentBinding

class ViewBindingShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = ViewBindingShowcaseFragment()
    }

    private lateinit var viewModel: ViewBindingShowcaseViewModel
    private lateinit var binding: ViewBindingShowcaseFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewBindingShowcaseFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewBindingShowcaseViewModel::class.java)
        binding.bindedView.text = viewModel.bindedView
    }

}
