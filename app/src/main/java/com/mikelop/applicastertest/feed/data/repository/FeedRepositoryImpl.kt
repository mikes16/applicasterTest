package com.mikelop.applicastertest.feed.data.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.common.utils.NetworkHandler
import com.mikelop.applicastertest.feed.data.entities.FeedData
import com.mikelop.applicastertest.feed.domain.repository.FeedRepository


internal class FeedRepositoryImpl(private val network: NetworkHandler,
                                  private val feedNet: FeedNetwork) : FeedRepository {

    override suspend fun getLinks(): Either<Failure, FeedData> {
        return if(network.isConnected){
            feedNet.getLinksJson()
        }else{
            Either.Left(Failure.NetworkConnection)
        }
    }

    override suspend fun getVideos(): Either<Failure, FeedData> {
        return if(network.isConnected){
            feedNet.getVideosJson()
        }else{
            Either.Left(Failure.NetworkConnection)
        }
    }
}