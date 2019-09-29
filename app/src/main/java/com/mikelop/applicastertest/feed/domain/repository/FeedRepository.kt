package com.mikelop.applicastertest.feed.domain.repository

import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.functional.Either
import com.mikelop.applicastertest.feed.domain.FeedDomain

interface FeedRepository{

    /**
     * Get The Links Json from the service
     *
     * @return Either<Failure, ResponseModel<ServiceModel>>
     * @see FeedDomain
     * */
    suspend fun getLinks(): Either<Failure, FeedDomain?>

}