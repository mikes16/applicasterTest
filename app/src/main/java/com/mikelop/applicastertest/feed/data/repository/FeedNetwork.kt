package com.mikelop.applicastertest.feed.data.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.extensions.defaultValue
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.common.functional.map
import com.mikelop.applicastertest.feed.data.entities.FeedData
import com.mikelop.applicastertest.feed.data.net.FeedApi

internal class FeedNetwork(
        private val feedApi: FeedApi){

    suspend fun getLinksJson(): Either<Failure, FeedData> {
        val response = feedApi.getLinksJson()
        return when(response.isSuccessful){
            true -> Either.Right(response).map{ it.body().defaultValue }
            false -> Either.Left(Failure.ServerError(response.code(), response.message()))
        }
    }

}