package com.mikelop.applicastertest.feed.data.entities

import com.google.gson.annotations.SerializedName

data class MediaGroupData(
    val type: String = "",
    @SerializedName("media_item")
    val mediaItem: ArrayList<MediaItemData> = arrayListOf()
)