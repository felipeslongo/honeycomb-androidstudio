package com.example.honeycomb.ui.viewBindings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class ViewBindingShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = ViewBindingShowcaseFragment()
    }

    private lateinit var viewModel: ViewBindingShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_binding_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewBindingShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
