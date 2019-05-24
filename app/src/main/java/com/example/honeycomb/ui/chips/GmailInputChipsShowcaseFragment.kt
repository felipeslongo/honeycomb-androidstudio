package com.example.honeycomb.ui.chips

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class GmailInputChipsShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = GmailInputChipsShowcaseFragment()
    }

    private lateinit var viewModel: GmailInputChipsShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gmail_input_chips_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GmailInputChipsShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
