package com.mikelop.applicastertest.feed.presentation.entities

import com.mikelop.applicastertest.feed.utils.FeedType

data class Entry(
    val type: FeedType = FeedType.NONE,
    val title: String = "",
    val summary: String = "",
    val published: String = "",
    val image: String = "",
    val contentSrc: String = "",
    val link: String = ""
)