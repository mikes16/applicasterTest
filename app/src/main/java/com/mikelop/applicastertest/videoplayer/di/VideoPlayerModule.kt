package com.mikelop.applicastertest.videoplayer.di

import com.mikelop.applicastertest.videoplayer.presentation.viewmodel.VideoPlayerViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val videoPlayerModule = module(createdAtStart = true, override = true) {
    viewModel{ (contentSrc: String) ->
        VideoPlayerViewModel(
            androidApplication(),
            contentSrc
        )
    }
}