package com.example.honeycomb.ui.buttons

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ButtonCheckinCheckoutBinding
import com.google.android.material.button.MaterialButton

class CheckInCheckOutView {
    val button: MaterialButton

    constructor(button: MaterialButton) {
        this.button = button

        val viewModel = CheckInCheckOutViewModel()
        val binding = DataBindingUtil.bind<ButtonCheckinCheckoutBinding>(this.button)
        binding!!.viewModel = viewModel
    }


    companion object{
        fun createFromParent(parent: View){
            CheckInCheckOutView(parent.findViewById(R.id.check_in_check_out_button))
        }

        fun createFromActivity(activity: Activity){
            CheckInCheckOutView(activity.findViewById(R.id.check_in_check_out_button))
        }
    }
}
