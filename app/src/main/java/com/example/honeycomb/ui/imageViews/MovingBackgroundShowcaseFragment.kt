package com.example.honeycomb.ui.imageViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.honeycomb.databinding.FragmentMovingbackgroundShowcaseBinding
import honeycomb.android.databinding.ViewMovingbackgroundBinding
import honeycomb.android.ui.imageViews.MovingBackgroundView

class MovingBackgroundShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = MovingBackgroundShowcaseFragment()
    }

    private lateinit var binding: FragmentMovingbackgroundShowcaseBinding
    private lateinit var viewModel: MovingBackgroundShowcaseViewModel

    private lateinit var movingBackgroundViewBindings: List<ViewMovingbackgroundBinding>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fun bindViews() {
            binding = FragmentMovingbackgroundShowcaseBinding.inflate(inflater)
            binding.lifecycleOwner = this

            movingBackgroundViewBindings = listOf(
                binding.viewMovingbackground,
                binding.viewMovingbackgroundInverse,
                binding.viewMovingbackgroundFast,
                binding.viewMovingbackgroundSlow,
                binding.viewMovingbackgroundZelda
            )
        }

        bindViews()
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
            movingBackgroundViewBindings.forEach {
                MovingBackgroundView.factory.createFromBinding(it, binding.lifecycleOwner!!)
            }
        }

        super.onActivityCreated(savedInstanceState)
        bindViewModel()
        bindViewModelsOfSubviews()
        viewModel.notifyActivityCreated()
    }

}
