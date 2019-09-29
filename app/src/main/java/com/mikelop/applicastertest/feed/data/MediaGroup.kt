package com.mikelop.applicastertest.feed.data

import com.google.gson.annotations.SerializedName

data class MediaGroup(
    private val type: String = "",
    @SerializedName("media_item")
    private val mediaItem: ArrayList<MediaItemDomain> = arrayListOf()
)