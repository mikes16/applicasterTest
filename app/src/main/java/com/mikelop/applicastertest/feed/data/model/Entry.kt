package com.mikelop.applicastertest.feed.data.model

import com.google.gson.annotations.SerializedName
import com.mikelop.applicastertest.feed.data.MediaGroupDomain

data class Entry(
    val type: Type = Type(),
    val title: String = "",
    val summary: String = "",
    val published: String = "",
    @SerializedName("media_group")
    val mediaGroup: MediaGroup = MediaGroup(),
    val link: Link = Link(),
    val content: Content = Content()
)