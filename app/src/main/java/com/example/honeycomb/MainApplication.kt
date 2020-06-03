package com.example.honeycomb

import android.app.Application
import honeycomb.androidx.emoji.text.EmojiCompatBootstrap
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MainScope().launch {
            EmojiCompatBootstrap().bootstrapAsync(this@MainApplication)
        }
    }

}