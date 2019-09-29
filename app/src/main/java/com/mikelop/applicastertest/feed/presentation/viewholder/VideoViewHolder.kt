package com.mikelop.applicastertest.feed.presentation.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_feed_video.view.*

internal open class VideoViewHolder (view: View) : FeedParentViewHolder(view){
    val titleTv: TextView = view.video_title_tv
    val summaryTv: TextView = view.video_summary_tv
    val imageIv: ImageView = view.video_main_iv
}