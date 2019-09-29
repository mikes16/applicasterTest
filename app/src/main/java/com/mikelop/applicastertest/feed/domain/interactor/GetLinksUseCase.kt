package com.mikelop.applicastertest.feed.domain.interactor

import com.mikelop.applicastertest.common.functional.map
import com.mikelop.applicastertest.common.interactor.UseCase
import com.mikelop.applicastertest.feed.domain.entities.FeedEntity
import com.mikelop.applicastertest.feed.domain.repository.FeedRepository
import com.mikelop.applicastertest.feed.domain.utils.toDomain


internal class GetLinksUseCase(private val repository: FeedRepository) : UseCase<FeedEntity, GetLinksUseCase.Params>() {

    override suspend fun run(params: Params) = repository.getLinks().map { it.toDomain }

    object Params
}