package com.samar.feedsystem.domain

interface FeedRepository {
    fun getFeedData(): List<FeedItem>
}

class MockFeedRepository : FeedRepository {
    override fun getFeedData(): List<FeedItem> {
        return listOf(
            TextFeedItem("Hello, this is a text post!", 1,
                System.currentTimeMillis().toString(), "user1"),
            ImageFeedItem("https://example.com/image.jpg", 2,
                System.currentTimeMillis().toString(), "user2"),
            VideoFeedItem("https://example.com/video.mp4", 3,
                System.currentTimeMillis().toString(), "user3")
        )
    }
}