package com.example.honeycomb.ui.buttons

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ButtonCheckinCheckoutBinding
import com.google.android.material.button.MaterialButton

class CheckInCheckOutView(val binding: ButtonCheckinCheckoutBinding) {

    init {
        binding.viewModel = CheckInCheckOutViewModel()
    }

    companion object{
        fun createFromParent(parent: View){
            val binding = createBinding(parent.findViewById(R.id.check_in_check_out_button))
            CheckInCheckOutView(binding)
        }

        fun createFromActivity(activity: Activity){
            val binding = createBinding(activity.findViewById(R.id.check_in_check_out_button))
            CheckInCheckOutView(binding)
        }

        private fun createBinding(view: MaterialButton): ButtonCheckinCheckoutBinding {
            return DataBindingUtil.bind(view)!!
        }
    }
}
