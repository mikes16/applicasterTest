package com.mikelop.applicastertest.feed.data.net

import com.mikelop.applicastertest.feed.data.entities.FeedData
import retrofit2.Response
import retrofit2.Retrofit

internal class FeedService(private val retrofit: Retrofit): FeedApi {

    private val feedApi by lazy { retrofit.create(FeedApi::class.java) }

    override suspend fun getLinksJson(): Response<FeedData> = feedApi.getLinksJson()

    override suspend fun getVideosJson(): Response<FeedData> = feedApi.getVideosJson()
}