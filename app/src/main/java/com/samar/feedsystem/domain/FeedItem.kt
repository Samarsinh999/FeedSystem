package com.samar.feedsystem.domain

sealed class FeedItem(open val id: String, open val timestamp: Long, open val username: String)

data class TextFeedItem(
    override val id: String,
    override val timestamp: Long,
    override val username: String,
    val textContent: String
) : FeedItem(id, timestamp, username)

data class ImageFeedItem(
    override val id: String,
    override val timestamp: Long,
    override val username: String,
    val imageUrls: String
) : FeedItem(id, timestamp, username)

data class VideoFeedItem(
    override val id: String,
    override val timestamp: Long,
    override val username: String,
    val videoUrl: String
) : FeedItem(id, timestamp, username)

data class SocialMediaFeedItem(
    val platform: String, // Example: "Instagram", "Facebook"
    val feedItem: FeedItem
)
