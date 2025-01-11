package com.samar.feedsystem.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.samar.feedsystem.R
import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.ImageFeedItem
import com.samar.feedsystem.domain.TextFeedItem
import com.samar.feedsystem.domain.VideoFeedItem

// FeedAdapter.kt
class FeedAdapter(
    private val feedItems: List<FeedItem>,
    private val onClick: (FeedItem) -> Unit,
    private val onLongClick: (FeedItem) -> Unit
) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feedContent: TextView = itemView.findViewById(R.id.feedContent)
        val feedImage: ImageView = itemView.findViewById(R.id.feedImage)
        val feedVideo: VideoView = itemView.findViewById(R.id.feedVideo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_layout, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feedItem = feedItems[position]
        when (feedItem) {
            is TextFeedItem -> {
                holder.feedContent.text = feedItem.textContent
                holder.feedContent.visibility = View.VISIBLE
                holder.feedImage.visibility = View.GONE
                holder.feedVideo.visibility = View.GONE
            }
            is ImageFeedItem -> {
                holder.feedImage.setImageURI(Uri.parse(feedItem.imageUrls))
                holder.feedImage.visibility = View.VISIBLE
                holder.feedContent.visibility = View.GONE
                holder.feedVideo.visibility = View.GONE
            }
            is VideoFeedItem -> {
                holder.feedVideo.setVideoURI(Uri.parse(feedItem.videoUrl))
                holder.feedVideo.visibility = View.VISIBLE
                holder.feedContent.visibility = View.GONE
                holder.feedImage.visibility = View.GONE
            }
        }

        // Click and long-click listeners
        holder.itemView.setOnClickListener { onClick(feedItem) }
        holder.itemView.setOnLongClickListener {
            onLongClick(feedItem)
            true
        }
    }

    override fun getItemCount(): Int = feedItems.size
}
