package com.example.honeycomb.ui.imageViews

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView

import com.example.honeycomb.R
import com.example.honeycomb.databinding.CircleImageShowcaseFragmentBinding
import com.example.honeycomb.ui.drawables.DrawableServices

class CircleImageShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = CircleImageShowcaseFragment()
    }

    private val viewModel by lazy { ViewModelProviders.of(this).get(CircleImageShowcaseViewModel::class.java) }
    private lateinit var binding: CircleImageShowcaseFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CircleImageShowcaseFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.circleImageShowcaseProgramaticallyCrop.setImageDrawable(DrawableServices.createAvatar(resources, R.drawable.image_skyward_sword))
        binding.circleImageShowcaseProgramaticallyAspectratio.setImageDrawable(DrawableServices.createAvatarWithAspectRatio(resources, R.drawable.image_skyward_sword))
    }

}
