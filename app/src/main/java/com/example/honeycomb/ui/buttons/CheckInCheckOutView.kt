package com.example.honeycomb.ui.buttons

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.CheckInCheckOutBinding
import com.example.honeycomb.ui.views.nullifyBehaviourOfAutoCheckOnClick
import com.google.android.material.button.MaterialButton

class CheckInCheckOutView(val binding: CheckInCheckOutBinding) {

    init {
        val viewModel = CheckInCheckOutViewModel.create()
        binding.viewModel = viewModel

        binding.checkInCheckOutButton.setOnClickListener {
            binding.checkInCheckOutButton.nullifyBehaviourOfAutoCheckOnClick()
            viewModel.toogleCheckInCheckOut()
        }
    }

    companion object{
        fun createFromParent(parent: View){
            val binding = createBinding(parent.findViewById(R.id.check_in_check_out_button))
            CheckInCheckOutView(binding)
        }

        fun createFromActivity(activity: AppCompatActivity){
            val binding = createBinding(activity.findViewById(R.id.check_in_check_out_button))
            CheckInCheckOutView(binding)
            binding.lifecycleOwner = activity
        }

        private fun createBinding(view: MaterialButton): CheckInCheckOutBinding {
            return DataBindingUtil.bind(view)!!
        }
    }
}
