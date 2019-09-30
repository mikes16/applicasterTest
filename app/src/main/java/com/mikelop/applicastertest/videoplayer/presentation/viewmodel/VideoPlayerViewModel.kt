package com.mikelop.applicastertest.videoplayer.presentation.viewmodel

import android.app.Application
import android.net.Uri
import android.support.v4.media.session.MediaSessionCompat
import androidx.lifecycle.*
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import okhttp3.internal.userAgent

class VideoPlayerViewModel(val context: Application, val contentSrc: String) : AndroidViewModel(context), LifecycleObserver {

    private val _player = MutableLiveData<Player?>()
    val player: LiveData<Player?> get() = _player

    private lateinit var mediaSession: MediaSessionCompat
    private var contentPosition = 0L

    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        setUpPlayer()
        initMediaSession()

        mediaSession.isActive = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        releasePlayer()
        mediaSession.isActive = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppDestroyed(){
        mediaSession.release()
    }

    private fun setUpPlayer() {
        val exoPlayer = ExoPlayerFactory.newSimpleInstance(context)
        val dataSourceFactory = DefaultDataSourceFactory(context, userAgent)
        val mediaSource = HlsMediaSource.Factory(dataSourceFactory)
            .setAllowChunklessPreparation(true)
            .createMediaSource(Uri.parse(contentSrc))
        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true
        exoPlayer.seekTo(contentPosition)
        this._player.value = exoPlayer
    }

    private fun initMediaSession(){
        mediaSession = MediaSessionCompat(context, context.packageName)
        val mediaSessionConnector = MediaSessionConnector(mediaSession)
        mediaSessionConnector.setPlayer(_player.value, null)
    }


    private fun releasePlayer() {
        val player = _player.value ?: return
        this._player.value = null

        contentPosition = player.contentPosition
        player.release()
    }

    override fun onCleared() {
        super.onCleared()
        releasePlayer()
        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
    }
}