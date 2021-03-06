package com.example.honeycomb.ui.buttons

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ButtonCheckincheckoutBinding
import com.example.honeycomb.ui.views.nullifyBehaviourOfAutoCheckOnClick
import com.google.android.material.button.MaterialButton

class CheckInCheckOutView(val binding: ButtonCheckincheckoutBinding) {

    init {
        val viewModel = CheckInCheckOutViewModel.create()
        binding.viewModel = viewModel

        binding.buttonCheckincheckout.setOnClickListener {
            binding.buttonCheckincheckout.nullifyBehaviourOfAutoCheckOnClick()
            viewModel.interpretIntent(ToggleCheckInCheckOutIntent())
        }
    }

    companion object{
        fun createFromParent(parent: View){
            val binding = createBinding(parent.findViewById(R.id.button_checkincheckout))
            CheckInCheckOutView(binding)
        }

        fun createFromActivity(activity: AppCompatActivity){
            val binding = createBinding(activity.findViewById(R.id.button_checkincheckout))
            CheckInCheckOutView(binding)
            binding.lifecycleOwner = activity
        }

        private fun createBinding(view: MaterialButton): ButtonCheckincheckoutBinding {
            return DataBindingUtil.bind(view)!!
        }
    }
}
