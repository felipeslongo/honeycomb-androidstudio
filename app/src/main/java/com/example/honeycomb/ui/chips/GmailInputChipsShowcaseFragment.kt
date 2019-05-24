package com.example.honeycomb.ui.chips

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class GmailInputChipsShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = GmailInputChipsShowcaseFragment()
    }

    private lateinit var root: ChipGroup
    private lateinit var viewModel: GmailInputChipsShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gmail_input_chips_showcase_fragment, container, false)

        root = view.findViewById(R.id.gmail_input_chips_showcase)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GmailInputChipsShowcaseViewModel::class.java)

        for (option in viewModel.options) {
            val chip = Chip(root.context)
            chip.text = "Chip Chip!"
            root.addView(chip,ChipGroup.LayoutParams.WRAP_CONTENT, ChipGroup.LayoutParams.WRAP_CONTENT)
        }

    }
}
