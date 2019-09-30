package com.mikelop.applicastertest.common.baseviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

abstract class KoinFragment : Fragment(){

    abstract fun getModules(): List<Module>
    abstract val layout:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(getModules())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(layout, container, false)
}