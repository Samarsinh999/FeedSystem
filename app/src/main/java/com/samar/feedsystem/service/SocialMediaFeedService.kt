package com.samar.feedsystem.service

import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.FeedManager
import com.samar.feedsystem.domain.FeedRepository
import com.samar.feedsystem.domain.InteractionType
import com.samar.feedsystem.domain.SocialMediaFeedItem

class SocialMediaFeedService(private val repository: FeedRepository, private val feedManager: FeedManager) {

    fun getPlatformFeeds(platform: String): List<FeedItem> {
        return repository.getFeedData().filter { (it as? SocialMediaFeedItem)?.platform == platform }
    }

    fun handlePlatformInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        feedManager.handleInteraction(feedItem, interactionType)
    }
}
