package com.mikelop.applicastertest.feed.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mikelop.applicastertest.common.baseviews.BaseViewModel
import com.mikelop.applicastertest.feed.domain.entities.FeedEntity
import com.mikelop.applicastertest.feed.domain.interactor.GetLinksUseCase
import com.mikelop.applicastertest.feed.domain.interactor.GetVideosUseCase
import com.mikelop.applicastertest.feed.presentation.entities.Entry
import com.mikelop.applicastertest.feed.presentation.utils.toView

internal class FeedViewModel(private val getLinksUseCase: GetLinksUseCase,
                             private val getVideosUseCase: GetVideosUseCase): BaseViewModel(){

    // Private values
    private var responses = 0
    private val entriesResponse: ArrayList<Entry> = arrayListOf()
    private val _entries: MutableLiveData<ArrayList<Entry>> = MutableLiveData()

    // Public values
    val entries: LiveData<ArrayList<Entry>> = _entries

    fun getFeedLinks(){
        if(entriesResponse.isEmpty()) {
            getVideosUseCase(GetVideosUseCase.Params) {
                it.either(::handleFailure, ::handleResponse)
            }

            getLinksUseCase(GetLinksUseCase.Params) {
                it.either(::handleFailure, ::handleResponse)
            }
        }
    }

    private fun handleResponse(feed: FeedEntity) {
        entriesResponse.addAll(feed.entry.toView)
        entriesResponse.shuffle()

        if(++responses > 1){
            _entries.postValue(entriesResponse)
            responses = 0
        }
    }

}