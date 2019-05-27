package com.example.honeycomb.ui.chips

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun ChipGroup.createExpandableChip(text: String, layoutInflater: LayoutInflater, removeOnCloseClicked: (Chip) -> Boolean) : Chip{
    val chip = Chip(this.context)
    chip.text = text
    chip.isClickable = true
    chip.isCheckable = false

    chip.setOnClickListener {
        chip.showExpandable(layoutInflater){
            if(removeOnCloseClicked(chip))
                this.removeView(chip)
        }
    }

    return chip
}