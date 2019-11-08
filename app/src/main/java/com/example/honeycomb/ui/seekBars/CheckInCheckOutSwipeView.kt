package com.example.honeycomb.ui.seekBars

import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ViewSwipeCheckincheckoutBinding

class CheckInCheckOutSwipeView(val binding: ViewSwipeCheckincheckoutBinding) :
    SeekBar.OnSeekBarChangeListener {

    init {
        binding.viewSwipeCheckincheckoutSeekbar.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (progress > 95) {
            seekBar?.thumb = seekBar!!.resources.getDrawable(R.drawable.ic_where_to_vote_32dp)
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    companion object{
        fun createFromActivity(activity: AppCompatActivity){
            val binding = createBinding(activity.findViewById(R.id.view_swipe_checkincheckout))
            CheckInCheckOutSwipeView(binding)
            binding.lifecycleOwner = activity
        }

        private fun createBinding(root: ConstraintLayout): ViewSwipeCheckincheckoutBinding {
            return DataBindingUtil.bind(root)!!
        }
    }
}
