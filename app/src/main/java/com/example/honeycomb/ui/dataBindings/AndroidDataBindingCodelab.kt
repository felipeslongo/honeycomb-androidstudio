package com.example.honeycomb.ui.dataBindings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.honeycomb.R
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity

class AndroidDataBindingCodelab : AppCompatActivity() {

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, AndroidDataBindingCodelab::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_data_binding_codelab)
    }
}
