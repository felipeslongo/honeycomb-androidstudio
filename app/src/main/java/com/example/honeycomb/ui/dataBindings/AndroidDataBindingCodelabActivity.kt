package com.example.honeycomb.ui.dataBindings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.honeycomb.R

class AndroidDataBindingCodelabActivity : AppCompatActivity() {

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, AndroidDataBindingCodelabActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_data_binding_codelab)
    }
}
