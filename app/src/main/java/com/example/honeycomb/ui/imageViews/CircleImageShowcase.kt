package com.example.honeycomb.ui.imageViews

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class CircleImageShowcase : Fragment() {

    companion object {
        fun newInstance() = CircleImageShowcase()
    }

    private lateinit var viewModel: CircleImageShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.circle_image_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CircleImageShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
