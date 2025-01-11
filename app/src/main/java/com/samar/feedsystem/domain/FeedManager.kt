package com.samar.feedsystem.domain

class FeedManager {

    fun handleInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        when (interactionType) {
            InteractionType.LONG_CLICK -> {
                if (feedItem is TextFeedItem) {
                    println("Text copied: ${feedItem.textContent}")
                }
            }
            InteractionType.CLICK_IMAGE -> {
                if (feedItem is ImageFeedItem) {
                    println("Image expanded: ${feedItem.imageUrls}")
                }
            }
            InteractionType.CLICK_VIDEO -> {
                if (feedItem is VideoFeedItem) {
                    println("Video playing: ${feedItem.videoUrl}")
                }
            }
            InteractionType.LIKE -> {
                println("Liked item: ${feedItem.id}")
            }
            InteractionType.COMMENT -> {
                println("Comment added on item: ${feedItem.id}")
            }
        }
    }
}
