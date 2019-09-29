package com.mikelop.applicastertest.feed.domain

import com.mikelop.applicastertest.feed.data.MediaGroupDomain
import com.mikelop.applicastertest.feed.utils.FeedType

data class FeedDomain(
    private val type: FeedType = FeedType.NONE,
    private val title: String = "",
    private val summary: String = "",
    private val published: String = "",
    private val mediaGroup: MediaGroupDomain = MediaGroupDomain(),
    private val contentSrc: String = "",
    private val link: String = ""
)