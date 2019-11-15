package com.example.honeycomb.ui.imageViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.honeycomb.databinding.FragmentMovingbackgroundShowcaseBinding
import honeycomb.android.ui.imageViews.MovingBackgroundView

class MovingBackgroundShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = MovingBackgroundShowcaseFragment()
    }

    private lateinit var binding: FragmentMovingbackgroundShowcaseBinding
    private lateinit var viewModel: MovingBackgroundShowcaseViewModel

    private lateinit var movingBackgroundView: MovingBackgroundView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovingbackgroundShowcaseBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        fun bindViewModel() {
            viewModel =
                ViewModelProviders.of(this).get(MovingBackgroundShowcaseViewModel::class.java)
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }

        fun bindViewModelsOfSubviews() {
            movingBackgroundView = MovingBackgroundView.createFromBinding(
                binding.viewMovingbackground,
                binding.lifecycleOwner!!
            )
        }

        super.onActivityCreated(savedInstanceState)
        bindViewModel()
        bindViewModelsOfSubviews()
        viewModel.movingBackgroundViewModel.start()
    }

}
