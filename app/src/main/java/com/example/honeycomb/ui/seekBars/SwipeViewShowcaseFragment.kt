package com.example.honeycomb.ui.seekBars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.honeycomb.databinding.FragmentSwipeViewShowcaseBinding
import honeycomb.android.databinding.ViewSwipeBinding
import honeycomb.android.ui.seekBars.SwipeView

class SwipeViewShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = SwipeViewShowcaseFragment()
    }

    private lateinit var binding: FragmentSwipeViewShowcaseBinding
    private lateinit var viewModel: SwipeViewShowcaseViewModel

    private lateinit var viewSwipeBindings: List<ViewSwipeBinding>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fun bindViews() {
            binding = FragmentSwipeViewShowcaseBinding.inflate(inflater)
            binding.lifecycleOwner = this

            viewSwipeBindings = listOf(
                binding.viewSwipe
            )
        }

        bindViews()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        fun bindViewModel() {
            viewModel = ViewModelProviders.of(this).get(SwipeViewShowcaseViewModel::class.java)
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }

        fun bindViewModelsOfSubviews() {
            viewSwipeBindings.forEach {
                SwipeView.factory.createFromBinding(it, binding.lifecycleOwner!!)
            }
        }

        super.onActivityCreated(savedInstanceState)
        bindViewModel()
        bindViewModelsOfSubviews()
        viewModel.notifyActivityCreated()
    }

}
