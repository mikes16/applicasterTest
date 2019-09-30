package com.mikelop.applicastertest.feed.presentation.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.videoplayer.presentation.view.VideoPlayerFragmentArgs
import kotlinx.android.synthetic.main.item_feed_video.view.*

internal open class VideoViewHolder (val view: View) : FeedParentViewHolder(view){
    val titleTv: TextView = view.video_title_tv
    val summaryTv: TextView = view.video_summary_tv
    val imageIv: ImageView = view.video_main_iv

    fun setClickListener(contentSrc: String = ""){
        view.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.videoPlayerFragment,
            VideoPlayerFragmentArgs(contentSrc).toBundle()))
    }
}