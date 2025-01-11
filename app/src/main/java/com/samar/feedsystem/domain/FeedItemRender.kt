package com.samar.feedsystem.domain

class FeedItemRenderer(private val feedManager: FeedManager) {

    fun renderFeed(feedItems: List<FeedItem>) {
        for (item in feedItems) {
            when (item) {
                is TextFeedItem -> println("Rendering text item: ${item.textContent}")
                is ImageFeedItem -> println("Rendering image item: ${item.imageUrls}")
                is VideoFeedItem -> println("Rendering video item: ${item.videoUrl}")
            }
        }
    }

    fun onInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        feedManager.handleInteraction(feedItem, interactionType)
    }
}
