package com.mikelop.applicastertest.feed.presentation.viewModel

import android.util.Log
import com.mikelop.applicastertest.common.baseviews.BaseViewModel
import com.mikelop.applicastertest.feed.domain.interactor.GetLinksUseCase
import com.mikelop.applicastertest.feed.presentation.toView

internal class FeedViewModel(private val getLinksUseCase: GetLinksUseCase): BaseViewModel(){

    fun getFeedLinks(){



        getLinksUseCase(GetLinksUseCase.Params){
            it.either(::handleFailure) { response ->
                response.toView
               Log.d("FeedViewModel", response.toString())
            }
        }
    }

}