package com.mikelop.applicastertest.feed.di

import com.mikelop.applicastertest.feed.data.net.FeedService
import com.mikelop.applicastertest.feed.data.repository.FeedNetwork
import com.mikelop.applicastertest.feed.data.repository.FeedRepositoryImpl
import com.mikelop.applicastertest.feed.domain.interactor.GetLinksUseCase
import com.mikelop.applicastertest.feed.presentation.viewModel.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedRepositoryModules = module(createdAtStart = true, override = true) {
    factory { FeedNetwork(get<FeedService>()) }
    factory { FeedRepositoryImpl(get(), get()) }
}

val feedModules = module(createdAtStart = true, override = true) {
    viewModel{ FeedViewModel(get()) }
    factory {  GetLinksUseCase(get<FeedRepositoryImpl>()) }
    factory { FeedService(get()) }
}