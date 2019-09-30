package com.mikelop.applicastertest.feed.presentation.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.link.presentation.view.NewsLinkFragmentArgs
import kotlinx.android.synthetic.main.item_feed_link.view.*

internal class LinkViewHolder (val view: View) : FeedParentViewHolder(view){
    val titleTv: TextView = view.link_title_tv
    val summaryTv: TextView = view.link_summary_tv
    val imageIv: ImageView = view.link_news_iv

    fun setClickListener(link: String = "", title: String = ""){
        view.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newsLinkFragment, NewsLinkFragmentArgs(link, title).toBundle()))
    }
}