package com.samar.feedsystem.domain

interface FeedRepository {
    fun getFeedData(): List<FeedItem>
}
