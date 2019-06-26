package com.example.honeycomb.ui.googlePlay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.honeycomb.R
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity

class SincronizacaoActivity : AppCompatActivity() {

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, SincronizacaoActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sincronizacao)
    }
}
