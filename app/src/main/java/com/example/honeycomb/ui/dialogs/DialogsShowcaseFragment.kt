package com.example.honeycomb.ui.dialogs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class DialogsShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = DialogsShowcaseFragment()
    }

    private lateinit var viewModel: DialogsShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialogs_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DialogsShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
