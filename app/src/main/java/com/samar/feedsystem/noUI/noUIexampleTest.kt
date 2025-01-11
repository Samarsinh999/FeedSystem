package com.samar.feedsystem.noUI

import FeedManager
import com.samar.feedsystem.domain.FeedAdapter
import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.FeedRepository
import com.samar.feedsystem.domain.ImageFeedItem
import com.samar.feedsystem.domain.TextFeedItem
import com.samar.feedsystem.domain.VideoFeedItem

fun main() {
    // Mock implementation of FeedRepository
    val feedRepository = object : FeedRepository {
        override fun getFeedData(): List<FeedItem> {
            return listOf(
                TextFeedItem("1", System.currentTimeMillis(), "User1", "This is a text post."),
                ImageFeedItem("2", System.currentTimeMillis(), "User2", "https://example.com/image.jpg"),
                VideoFeedItem("3", System.currentTimeMillis(), "User3", "https://example.com/video.mp4")
            )
        }
    }

    // Initialize FeedManager with the repository
    val feedManager = FeedManager(feedRepository)

    // Fetch feed data
    val feedItems = feedManager.fetchFeed()

    // Initialize FeedAdapter
    val feedAdapter = FeedAdapter(feedItems, feedManager)

    // Simulate interactions
    feedAdapter.bindView("1") // Text clicked
    feedAdapter.longClickView("2") // Image long-clicked
    feedAdapter.likeView("3") // Video liked
    feedAdapter.commentView("1") // Text commented on
}
