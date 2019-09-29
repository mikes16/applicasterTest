package com.mikelop.applicastertest.feed.data.model

import com.mikelop.applicastertest.feed.data.MediaItemDomain

data class MediaItem(
    val src: String = "",
    val type: String = "",
    val scale: String = "",
    val key: String = ""
)

val ArrayList<MediaItem>.toDomain: ArrayList<MediaItemDomain> get() = this.run {
    val arrayList = arrayListOf<MediaItemDomain>()
    this.forEach{
        arrayList.add(
            MediaItemDomain(
                src = it.src,
                type = it.type,
                scale = it.scale,
                key = it.key
            )
        )
    }
    arrayList
}




