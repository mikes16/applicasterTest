package com.mikelop.applicastertest.videoplayer.presentation.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.Player
import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.app.MainActivity
import com.mikelop.applicastertest.common.baseviews.KoinFragment
import com.mikelop.applicastertest.videoplayer.presentation.viewmodel.VideoPlayerViewModel
import org.koin.core.module.Module
import kotlinx.android.synthetic.main.fragment_video_player.view.*
import com.mikelop.applicastertest.videoplayer.di.videoPlayerModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


/**
 * A simple [KoinFragment] subclass.
 */
class VideoPlayerFragment : KoinFragment(), Player.EventListener {

    private val args: VideoPlayerFragmentArgs by navArgs()
    private val videoPlayerViewModel by viewModel<VideoPlayerViewModel> { parametersOf(args.contentSrc) }

    override fun getModules(): List<Module> = arrayListOf(videoPlayerModule)
    override val layout: Int = R.layout.fragment_video_player

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }
    override fun onStart() {
        super.onStart()

        videoPlayerViewModel.player.observe(viewLifecycleOwner, onPlayerReady)
    }

    override fun onDestroy() {
        super.onDestroy()

        activity!!.window.decorView.systemUiVisibility = 0
        (activity as MainActivity).showNavBar()
    }

    private val onPlayerReady = Observer<Player?>{
        view?.video_view?.player = it
        view?.video_view?.useController = true
        view?.video_view?.requestFocus()
    }

    private fun hideSystemUI() {
        activity!!.window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        (activity as MainActivity).showNavBar(false)
    }


}
