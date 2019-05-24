package com.example.honeycomb.ui.chips

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.honeycomb.R
import com.google.android.material.chip.Chip

class ExpandableChipShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = ExpandableChipShowcaseFragment()
    }

    private lateinit var viewModel: ExpandableChipShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.expandable_chip_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpandableChipShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var view = activity!!.findViewById<Chip>(R.id.expandable_chip_showcase_fragment_chip)
        view.setOnClickListener {
            view.showExpandable(layoutInflater){
                Toast.makeText(activity, "Close Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }
}
