package com.example.honeycomb.ui.sync

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.honeycomb.R



class SincronizacaoFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.sincronizacao_completa, container, false)

    companion object{
        private val dialogTag: String = "SincronizacaoFragment"

        fun apresentar(activity: AppCompatActivity) : SincronizacaoFragment{

            val ft = activity.supportFragmentManager.beginTransaction()
            val fragmentoPerdido = activity.supportFragmentManager.findFragmentByTag(dialogTag)
            if (fragmentoPerdido != null)
                ft.remove(fragmentoPerdido)
            ft.addToBackStack(null)

            val dialogFragment = SincronizacaoFragment()
            dialogFragment.show(ft, dialogTag)
            return dialogFragment
        }
    }
}