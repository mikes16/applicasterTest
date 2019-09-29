package com.mikelop.applicastertest.feed.domain.entities

import com.mikelop.applicastertest.feed.utils.FeedType

data class EntryEntity(
    val type: FeedType = FeedType.NONE,
    val title: String = "",
    val summary: String = "",
    val published: String = "",
    val mediaGroup: ArrayList<MediaGroupEntity> = arrayListOf(),
    val contentSrc: String = "",
    val link: String = ""
)