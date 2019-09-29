package com.mikelop.applicastertest.feed.data.model

import com.mikelop.applicastertest.feed.domain.FeedDomain

data class Feed(val entry: Entry = Entry())

val Feed.toDomain: FeedDomain? get() = FeedDomain(
    type = this.entry.type.value,
    title = this.entry.title,
    summary = this.entry.summary,
    published = this.entry.published,
    mediaGroup = this.entry.mediaGroup.toDomain,
    contentSrc = this.entry.content.src,
    link = this.entry.link.href
)