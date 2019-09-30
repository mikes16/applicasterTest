package com.mikelop.applicastertest.feed.utils

import com.google.gson.annotations.SerializedName

enum class FeedType {
    @SerializedName("link") LINK,
    @SerializedName("video") VIDEO,
    NONE
}