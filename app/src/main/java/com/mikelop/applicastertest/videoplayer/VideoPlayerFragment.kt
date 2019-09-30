package com.mikelop.applicastertest.videoplayer


import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.common.baseviews.KoinFragment
import org.koin.core.module.Module

/**
 * A simple [KoinFragment] subclass.
 */
class VideoPlayerFragment : KoinFragment() {

    override fun getModules(): List<Module> = arrayListOf()
    override val layout: Int = R.layout.fragment_video_player

}
