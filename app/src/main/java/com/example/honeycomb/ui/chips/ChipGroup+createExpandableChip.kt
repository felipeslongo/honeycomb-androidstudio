package com.example.honeycomb.ui.chips

import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun ChipGroup.createExpandableChip(text: String) : Chip{
    val chip = Chip(this.context)
    chip.text = text
    chip.isClickable = true
    chip.isCheckable = false

    return chip
}