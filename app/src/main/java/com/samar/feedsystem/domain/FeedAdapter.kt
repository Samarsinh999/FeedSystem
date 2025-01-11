package com.samar.feedsystem.domain

import FeedManager

class FeedAdapter(
    private val feedItems: List<FeedItem>,
    private val feedManager: FeedManager
) {

    fun bindView(itemId: String) {
        val item = feedItems.find { it.id == itemId }
        item?.let { feedManager.handleInteraction(it, InteractionType.CLICK_IMAGE) }
    }

    fun longClickView(itemId: String) {
        val item = feedItems.find { it.id == itemId }
        item?.let { feedManager.handleInteraction(it, InteractionType.LONG_CLICK) }
    }

    fun likeView(itemId: String) {
        val item = feedItems.find { it.id == itemId }
        item?.let { feedManager.handleInteraction(it, InteractionType.LIKE) }
    }

    fun commentView(itemId: String) {
        val item = feedItems.find { it.id == itemId }
        item?.let { feedManager.handleInteraction(it, InteractionType.COMMENT) }
    }
}
