package com.mikelop.applicastertest.feed.presentation

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
                mediaGroup = it.mediaGroup.toView,
                contentSrc = it.contentSrc,
                link = it.link
            )
        )
    }
    arrayList
}

@get:JvmName("MediaItemEntityToView")
val ArrayList<MediaItemEntity>.toView: ArrayList<MediaItemEntity> get() = this.run {
    val arrayList = arrayListOf<MediaItemEntity>()
    this.forEach{
        arrayList.add(
            MediaItemEntity(
                src = it.src,
                type = it.type,
                scale = it.scale,
                key = it.key
            )
        )
    }
    arrayList
}


@get:JvmName("MediaGroupEntityToView")
val ArrayList<MediaGroupEntity>.toView: ArrayList<MediaGroup> get() = this.run {
    val arrayList = arrayListOf<MediaGroup>()
    this.forEach {
        arrayList.add(
            MediaGroup(
                type = it.type,
                mediaItem = it.mediaItem.toView
            )
        )
    }
    arrayList
}