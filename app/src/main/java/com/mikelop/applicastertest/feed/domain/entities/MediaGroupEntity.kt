package com.mikelop.applicastertest.feed.domain.entities

import com.google.gson.annotations.SerializedName

data class MediaGroupEntity(
    val type: String = "",
    @SerializedName("media_item")
    val mediaItem: ArrayList<MediaItemEntity> = arrayListOf()
)