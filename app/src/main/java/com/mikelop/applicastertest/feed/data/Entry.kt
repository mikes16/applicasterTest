package com.mikelop.applicastertest.feed.data

import com.google.gson.annotations.SerializedName

data class Entry(
    private val type: Type = Type(),
    private val title: String = "",
    private val summary: String = "",
    private val published: String = "",
    @SerializedName("media_group")
    private val mediaGroup: MediaGroupDomain = MediaGroupDomain(),
    private val link: Link = Link(),
    private val content: Content = Content()
)