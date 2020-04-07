package com.github.felipeslongo.honeycomb.mercos.agenda

import android.view.animation.AnimationUtils
import com.github.felipeslongo.honeycomb.mercos.R
import com.github.felipeslongo.honeycomb.mercos.databinding.ContentListagemAgendaBinding
import com.google.android.material.tabs.TabLayout

val ContentListagemAgendaBinding.tabProgramados : TabLayout.Tab
    get() = tabLayout.getTabAt(AbaDaListagemAgendaEnum.PROGRAMADOS.indice)!!

val ContentListagemAgendaBinding.tabRealizados : TabLayout.Tab
    get() = tabLayout.getTabAt(AbaDaListagemAgendaEnum.REALIZADOS.indice)!!

fun ContentListagemAgendaBinding.selecionarAbaProgramados() {
    tabProgramados.select()
    viewSwitcher?.inAnimation = AnimationUtils.loadAnimation(root.context, R.anim.slide_in_left_viewpager)
    viewSwitcher?.outAnimation = AnimationUtils.loadAnimation(root.context, R.anim.slide_out_right_viewpager)
    viewSwitcher.displayedChild = tabProgramados.position
}

fun ContentListagemAgendaBinding.selecionarAbaRealizados() {
    tabRealizados.select()
    viewSwitcher?.inAnimation = AnimationUtils.loadAnimation(root.context, R.anim.slide_in_right_viewpager)
    viewSwitcher?.outAnimation = AnimationUtils.loadAnimation(root.context, R.anim.slide_out_left_viewpager)
    viewSwitcher.displayedChild = tabRealizados.position
}