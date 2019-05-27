package com.example.honeycomb.ui.chips

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatAutoCompleteTextView

import com.example.honeycomb.R
import com.example.honeycomb.ui.viewGroups.addViewBefore
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class GmailInputChipsShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = GmailInputChipsShowcaseFragment()
    }

    private lateinit var chips: ChipGroup
    private lateinit var input : AppCompatAutoCompleteTextView
    private lateinit var viewModel: GmailInputChipsShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gmail_input_chips_showcase_fragment, container, false)

        chips = view.findViewById(R.id.gmail_input_chips_showcase_chips)
        input = view.findViewById(R.id.gmail_input_chips_showcase_input)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GmailInputChipsShowcaseViewModel::class.java)

        for (option in viewModel.options) {
            addChip(option)
        }
    }

    private fun addChip(text: String) {
        val chip = chips.createExpandableChip(text, layoutInflater){
            true
        }

        chip.setChipBackgroundColorResource(R.color.chipExpandableBackground)
        chips.addView(chip)
    }
}
