package com.mikelop.applicastertest.feed.presentation.entities

import com.mikelop.applicastertest.feed.utils.FeedType

data class Entry(
    private val type: FeedType = FeedType.NONE,
    private val title: String = "",
    private val summary: String = "",
    private val published: String = "",
    private val mediaGroup: ArrayList<MediaGroup> = arrayListOf(),
    private val contentSrc: String = "",
    private val link: String = ""
)