package com.mikelop.applicastertest.feed.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.feed.presentation.entities.Entry
import com.mikelop.applicastertest.feed.presentation.utils.TYPE_LINK
import com.mikelop.applicastertest.feed.presentation.utils.TYPE_NONE
import com.mikelop.applicastertest.feed.presentation.utils.TYPE_VIDEO
import com.mikelop.applicastertest.feed.presentation.viewholder.FeedParentViewHolder
import com.mikelop.applicastertest.feed.presentation.viewholder.LinkViewHolder
import com.mikelop.applicastertest.feed.presentation.viewholder.VideoViewHolder
import com.mikelop.applicastertest.feed.utils.FeedType

@Suppress("UNCHECKED_CAST")
internal class FeedEntriesAdapter(private val entries:ArrayList<Entry>) : RecyclerView.Adapter<FeedParentViewHolder>(), Filterable{

    private var entriesFiltered = entries

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedParentViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when(viewType){
            TYPE_LINK -> LinkViewHolder(view.inflate(R.layout.item_feed_link, parent, false))
            TYPE_VIDEO -> VideoViewHolder(view.inflate(R.layout.item_feed_video, parent, false))
            else -> throw UnknownError()
        }
    }

    override fun getItemViewType(position: Int): Int = when(entriesFiltered[position].type){
        FeedType.LINK -> TYPE_LINK
        FeedType.VIDEO -> TYPE_VIDEO
        else -> TYPE_NONE
    }

    override fun getItemCount(): Int = entriesFiltered.size

    override fun onBindViewHolder(holder: FeedParentViewHolder, position: Int) = when(getItemViewType(position)){
        TYPE_LINK -> handleLinkPost(holder as LinkViewHolder, entriesFiltered[position])
        TYPE_VIDEO -> handleVideoPost(holder as VideoViewHolder, entriesFiltered[position])
        else -> throw UnknownError()
    }

    /**
     * getFilter - Function to filter the recycler view to find per title.
     *
     * */
    override fun getFilter(): Filter {
        return object : Filter() {
            @SuppressLint("DefaultLocale")
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                entriesFiltered = if (charString.isEmpty()) {
                    entries
                } else {
                    val filteredList = ArrayList<Entry>()
                    for (row in entries) {
                        if (row.title.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }

                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = entriesFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                entriesFiltered = filterResults.values as ArrayList<Entry>
                notifyDataSetChanged()
            }
        }
    }

    /**
     * handleLinkPost - Handles the incoming link messages.
     *
     * @param holder instance of [LinkViewHolder] class
     * @param entry instance of [Entry] object
     * */
    private fun handleLinkPost(holder: LinkViewHolder, entry: Entry){
        holder.titleTv.text = entry.title
        holder.summaryTv.text = entry.summary
        holder.setClickListener(entry.link, entry.title)

        Glide.with(holder.itemView.context)
            .load(entry.image) // TODO: change this form the domain to get the image
            .centerCrop()
            .thumbnail()
            .into(holder.imageIv)
    }

    /**
     * handleVideoPost - Handles the incoming video messages.
     *
     * @param holder instance of [VideoViewHolder] class
     * @param entry instance of [Entry] object
     * */
    private fun handleVideoPost(holder: VideoViewHolder, entry: Entry){
        holder.titleTv.text =  entry.title
        holder.summaryTv.text = entry.summary
        holder.setClickListener(entry.contentSrc)

        Glide.with(holder.itemView.context)
            .load(entry.image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .thumbnail()
            .into(holder.imageIv)
    }
}