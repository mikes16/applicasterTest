package com.mikelop.applicastertest.feed.data.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.common.functional.map
import com.mikelop.applicastertest.common.utils.NetworkHandler
import com.mikelop.applicastertest.feed.data.model.toDomain
import com.mikelop.applicastertest.feed.domain.FeedDomain
import com.mikelop.applicastertest.feed.domain.repository.FeedRepository


internal class FeedRepositoryImpl(private val network: NetworkHandler,
                                  private val feedNet: FeedNetwork) : FeedRepository {

    override suspend fun getLinks(): Either<Failure, FeedDomain?> {
        return if(network.isConnected){
            val response = feedNet.getLinksJson()
            Either.Right(response).map{ it?.toDomain }
        }else{
            Either.Left(Failure.NetworkConnection)
        }
    }
}