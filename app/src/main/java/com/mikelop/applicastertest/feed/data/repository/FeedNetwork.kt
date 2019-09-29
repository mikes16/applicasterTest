package com.mikelop.applicastertest.feed.data.repository

import com.mikelop.applicastertest.feed.data.model.Feed
import com.mikelop.applicastertest.feed.data.net.FeedApi

internal class FeedNetwork(
        private val feedApi: FeedApi){

    suspend fun getLinksJson(): Feed? {
        val response = feedApi.getLinksJson()
        return when(response.isSuccessful){
            true -> response.body()
            false -> Feed()
        }
    }

}