package com.mikelop.applicastertest.feed.data.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.common.functional.map
import com.mikelop.applicastertest.feed.data.model.toDomain
import com.mikelop.applicastertest.feed.data.net.FeedApi
import com.mikelop.applicastertest.feed.domain.FeedDomain

internal class FeedNetwork(
        private val feedApi: FeedApi){

    suspend fun getLinksJson(): Either<Failure, FeedDomain?> {
        val response = feedApi.getLinksJson()
        return when(response.isSuccessful){
            true -> Either.Right(response).map{ it.body()?.toDomain }
            false -> Either.Left(Failure.ServerError(response.code(), response.message()))
        }
    }

}