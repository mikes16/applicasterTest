package com.mikelop.applicastertest.link.presentation.view

import androidx.fragment.app.Fragment

import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.common.baseviews.KoinFragment
import org.koin.core.module.Module

/**
 * A simple [Fragment] subclass.
 */
class NewsLinkFragment : KoinFragment() {

    override fun getModules(): List<Module> = arrayListOf()
    override val layout: Int = R.layout.fragment_news_link



}
