package com.example.honeycomb.ui.buttons

import android.app.Activity
import android.view.View
import com.example.honeycomb.R
import com.google.android.material.button.MaterialButton

class CheckInCheckOutView {
    val button: MaterialButton

    constructor(button: MaterialButton) {
        this.button = button
        this.button.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_where_to_vote_24dp,0,0)
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
