package com.example.honeycomb.ui.progressBars

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

/**
 *  Sets the value of the progress bar so that 5 likes will fill it up.
 *
 *  Showcases Binding Adapters with multiple attributes. Note that this adapter is called
 *  whenever any of the attribute changes.
 */
@BindingAdapter(value = ["app:progressScaled", "android:progressScaledMax"], requireAll = true)
fun progressScaled(progressBar: ProgressBar, likes: Int, max: Int){
    progressBar.progress = (likes * max / 5).coerceAtMost(max)
}