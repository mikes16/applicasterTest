package com.mikelop.applicastertest.feed.data.model

import com.google.gson.annotations.SerializedName
import com.mikelop.applicastertest.feed.data.MediaGroupDomain
import com.mikelop.applicastertest.feed.data.MediaItemDomain

data class MediaGroup(
    val type: String = "",
    @SerializedName("media_item")
    val mediaItem: ArrayList<MediaItem> = arrayListOf()
)

val MediaGroup.toDomain: MediaGroupDomain get() = MediaGroupDomain(
    type = this.type,
    mediaItem = this.mediaItem.toDomain
)