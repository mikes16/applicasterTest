package com.mikelop.applicastertest.feed.presentation.utils

import com.mikelop.applicastertest.feed.domain.entities.EntryEntity
import com.mikelop.applicastertest.feed.domain.entities.FeedEntity
import com.mikelop.applicastertest.feed.domain.entities.MediaGroupEntity
import com.mikelop.applicastertest.feed.presentation.entities.MediaGroup
import com.mikelop.applicastertest.feed.domain.entities.MediaItemEntity
import com.mikelop.applicastertest.feed.presentation.entities.Entry
import com.mikelop.applicastertest.feed.presentation.entities.Feed

val FeedEntity.toView: Feed get() = Feed(
    entry = this.entry.toView
)

@get:JvmName("EntryEntityToView")
val ArrayList<EntryEntity>.toView: ArrayList<Entry> get() = this.run {
    val arrayList = arrayListOf<Entry>()
    this.forEach {
        arrayList.add(
            Entry(
                type = it.type,
                title = it.title,
                summary = it.summary,
                published = it.published,
                image = it.mediaGroup.getImage(),
                contentSrc = it.contentSrc,
                link = it.link
            )
        )
    }
    arrayList
}

fun ArrayList<MediaGroupEntity>.getImage(): String {
    var imageSrc = ""
    this.forEach{
        it.mediaItem.forEach{ mediaItem ->
            if(mediaItem.key == "image_base"){
                imageSrc = mediaItem.src
            }
        }
    }

    return imageSrc
}