package com.samar.feedsystem.service

import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.FeedManager
import com.samar.feedsystem.domain.FeedRepository
import com.samar.feedsystem.domain.InteractionType

class FeedService(private val repository: FeedRepository, private val feedManager: FeedManager) {

    fun getAllFeeds(): List<FeedItem> {
        return repository.getFeedData()
    }

    fun handleInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        feedManager.handleInteraction(feedItem, interactionType)
    }
}
