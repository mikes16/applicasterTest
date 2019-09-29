package com.mikelop.applicastertest.feed.data.net

import com.mikelop.applicastertest.feed.data.model.Feed
import retrofit2.Response
import retrofit2.Retrofit

internal class FeedService(private val retrofit: Retrofit): FeedApi {

    private val chatApi by lazy { retrofit.create(FeedApi::class.java) }

    override suspend fun getLinksJson(): Response<Feed> = chatApi.getLinksJson()
}