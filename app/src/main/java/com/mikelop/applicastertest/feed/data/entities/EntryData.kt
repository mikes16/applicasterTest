package com.mikelop.applicastertest.feed.data.entities

import com.google.gson.annotations.SerializedName

data class EntryData(
    val type: TypeData = TypeData(),
    val title: String = "",
    val summary: String = "",
    val published: String = "",
    @SerializedName("media_group")
    val mediaGroup: ArrayList<MediaGroupData> = arrayListOf(),
    val link: LinkData = LinkData(),
    val content: ContentData = ContentData()
)