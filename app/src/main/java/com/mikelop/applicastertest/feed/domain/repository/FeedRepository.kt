package com.mikelop.applicastertest.feed.domain.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.feed.data.entities.FeedData

interface FeedRepository{

    /**
     * Get The Links Json from the service
     *
     * @return Either<Failure, FeedData>
     * @see FeedData
     * */
    suspend fun getLinks(): Either<Failure, FeedData>

    /**
     * Get The Videos Json from the service
     *
     * @return Either<Failure, FeedData>
     * @see FeedData
     * */
    suspend fun getVideos(): Either<Failure, FeedData>

}