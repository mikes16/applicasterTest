package com.mikelop.applicastertest.feed.presentation.model

import com.mikelop.applicastertest.feed.data.MediaGroupDomain
import com.mikelop.applicastertest.feed.utils.FeedType

data class FeedView(
    private val title: FeedType = FeedType.NONE,
    private val summary: String = "",
    private val published: String = "",
    private val mediaGroup: MediaGroupDomain = MediaGroupDomain(),
    private val type: String = "",
    private val contentSrc: String = "",
    private val link: String = ""
)