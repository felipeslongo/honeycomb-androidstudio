package com.example.honeycomb.ui.dataBindings

/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.honeycomb.R
import com.example.honeycomb.databinding.ActivityAndroidDataBindingCodelabBinding

/**
 * Plain old activity with lots of problems to fix.
 */
class AndroidDataBindingCodelabActivity : AppCompatActivity() {

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, AndroidDataBindingCodelabActivity::class.java))
        }
    }

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(AndroidDataBindingCodelabViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_android_data_binding_codelab)
        val binding: ActivityAndroidDataBindingCodelabBinding = DataBindingUtil.setContentView(this, R.layout.activity_android_data_binding_codelab)

        binding.name = "Felipe"
        binding.lastName = "de Souza Longo"

        // TODO: Explicitly setting initial values is a bad pattern. We'll fix that.
        updateLikes()
    }

    /**
     * This method is triggered by the `android:onclick` attribute in the layout. It puts business
     * logic in the activity, which is not ideal. We should do something about that.
     */
    fun onLike(view: View) {
        viewModel.onLike()
        updateLikes()
    }

    /**
     * This method has many problems:
     * - It's calling findViewById multiple times
     * - It has untestable logic
     * - It's updating two views when called even if they're not changing
     */
    private fun updateLikes() {
        findViewById<TextView>(R.id.likes).text = viewModel.likes.toString()
        findViewById<ProgressBar>(R.id.progressBar).progress =
            (viewModel.likes * 100 / 5).coerceAtMost(100)
        val image = findViewById<ImageView>(R.id.imageView)

        val color = getAssociatedColor(viewModel.popularity, this)

        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color))

        image.setImageDrawable(getDrawablePopularity(viewModel.popularity, this))
    }

    private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
        return when (popularity) {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0, 0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }

    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }
}
