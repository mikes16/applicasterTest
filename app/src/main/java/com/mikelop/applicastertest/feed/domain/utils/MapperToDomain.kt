package com.mikelop.applicastertest.feed.domain.utils

import com.mikelop.applicastertest.feed.data.entities.EntryData
import com.mikelop.applicastertest.feed.data.entities.FeedData
import com.mikelop.applicastertest.feed.data.entities.MediaGroupData
import com.mikelop.applicastertest.feed.data.entities.MediaItemData
import com.mikelop.applicastertest.feed.domain.entities.EntryEntity
import com.mikelop.applicastertest.feed.domain.entities.FeedEntity
import com.mikelop.applicastertest.feed.domain.entities.MediaGroupEntity
import com.mikelop.applicastertest.feed.domain.entities.MediaItemEntity

val FeedData.toDomain: FeedEntity get() = FeedEntity(
    entry = this.entry.toDomain
)

@get:JvmName("EntryDataToDomain")
val ArrayList<EntryData>.toDomain: ArrayList<EntryEntity> get() = this.run {
    val arrayList = arrayListOf<EntryEntity>()
    this.forEach {
        arrayList.add(
            EntryEntity(
                type = it.type.value,
                title = it.title,
                summary = it.summary,
                published = it.published,
                mediaGroup = it.mediaGroup.toDomain,
                contentSrc = it.content.src,
                link = it.link.href
            )
        )
    }
    arrayList
}



@get:JvmName("MediaItemDataToDomain")
val ArrayList<MediaItemData>.toDomain: ArrayList<MediaItemEntity> get() = this.run {
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

@get:JvmName("MediaGroupDataToDomain")
val ArrayList<MediaGroupData>.toDomain: ArrayList<MediaGroupEntity> get() = this.run {
    val arrayList = arrayListOf<MediaGroupEntity>()
    this.forEach {
        arrayList.add(
            MediaGroupEntity(
                type = it.type,
                mediaItem = it.mediaItem.toDomain
            )
        )
    }
    arrayList
}