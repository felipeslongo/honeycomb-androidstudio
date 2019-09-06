package com.example.honeycomb.ui.miscellaneous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.honeycomb.R
import com.example.honeycomb.databinding.BeamerViewBinding
import com.example.honeycomb.ui.navigationViews.NavigationViewShowcaseActivity
import kotlinx.android.synthetic.main.beamer_view.view.*

class BeamerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: BeamerViewBinding = DataBindingUtil.setContentView(this, R.layout.beamer_view)
        binding.lifecycleOwner = this


        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://app.getbeamer.com/news?app_id=mZXqptmd65&language=en&filterByUrl=true&role=paid-user&custom_user_id=1234&email=john%40getbeamer.com&firstname=John&lastname=Doe")

    }

    companion object{
        fun present(caller: AppCompatActivity){
            caller.startActivity(Intent(caller, BeamerActivity::class.java))
        }
    }
}
