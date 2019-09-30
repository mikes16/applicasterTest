package com.mikelop.applicastertest.feed.presentation.entities

import com.google.gson.annotations.SerializedName
import com.mikelop.applicastertest.feed.domain.entities.MediaItemEntity

data class MediaGroup(
    val type: String = "",
    @SerializedName("media_item")
    val mediaItem: ArrayList<MediaItemEntity> = arrayListOf()
)