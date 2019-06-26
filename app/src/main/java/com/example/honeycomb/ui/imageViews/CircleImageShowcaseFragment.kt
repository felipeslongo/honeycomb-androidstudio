package com.example.honeycomb.ui.imageViews

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView

import com.example.honeycomb.R
import com.example.honeycomb.ui.drawables.DrawableServices

class CircleImageShowcaseFragment : Fragment() {

    companion object {
        fun newInstance() = CircleImageShowcaseFragment()
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

        var imageProgramaticallyCrop = view!!.findViewById<AppCompatImageView>(R.id.circle_image_showcase_programatically_crop)
        imageProgramaticallyCrop.setImageDrawable(DrawableServices.createAvatar(resources, R.drawable.image_skyward_sword))

        var imageProgramaticallyAspectRatio = view!!.findViewById<AppCompatImageView>(R.id.circle_image_showcase_programatically_aspectratio)
        imageProgramaticallyAspectRatio.setImageDrawable(DrawableServices.createAvatarWithAspectRatio(resources, R.drawable.image_skyward_sword))
    }

}
