package com.example.honeycomb.ui.badges

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.honeycomb.R

class BadgeShowcase : Fragment() {

    companion object {
        fun newInstance() = BadgeShowcase()
    }

    private lateinit var viewModel: BadgeShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.badge_showcase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BadgeShowcaseViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
