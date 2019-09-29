package com.mikelop.applicastertest.feed.presentation.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mikelop.applicastertest.R
import kotlinx.android.synthetic.main.item_feed_link.view.*

internal class LinkViewHolder (view: View) : FeedParentViewHolder(view){
    val titleTv: TextView = view.link_title_tv
    val summaryTv: TextView = view.link_summary_tv
    val imageIv: ImageView = view.link_news_iv
    val contentSrc: String = ""

    init {
        val bundle = bundleOf("contentSrc" to contentSrc)
        view.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newsLinkFragment, bundle))
    }
}