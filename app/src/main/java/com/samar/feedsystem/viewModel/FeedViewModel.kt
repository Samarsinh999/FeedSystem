package com.samar.feedsystem.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.FeedRepository
import com.samar.feedsystem.domain.ImageFeedItem
import com.samar.feedsystem.domain.TextFeedItem
import com.samar.feedsystem.domain.VideoFeedItem

// FeedViewModel.kt
class FeedViewModel(private val repository: FeedRepository) : ViewModel() {

    private val _feedItems = MutableLiveData<List<FeedItem>>()
    val feedItems: LiveData<List<FeedItem>> = _feedItems

    // Expose user interaction events
    private val _interactionEvent = MutableLiveData<String>()
    val interactionEvent: LiveData<String> = _interactionEvent

    // Fetch feed data
    fun fetchFeedData() {
        _feedItems.value = repository.getFeedData()
    }

    // Handle interactions
    fun handleInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        when (interactionType) {
            InteractionType.CLICK -> {
                if (feedItem is TextFeedItem) {
                    _interactionEvent.value = "Clicked on text: ${feedItem.textContent}"
                } else if (feedItem is ImageFeedItem) {
                    _interactionEvent.value = "Clicked on image: ${feedItem.imageUrls}"
                } else if (feedItem is VideoFeedItem) {
                    _interactionEvent.value = "Clicked on video: ${feedItem.videoUrl}"
                }
            }
            InteractionType.LONG_CLICK -> {
                if (feedItem is TextFeedItem) {
                    _interactionEvent.value = "Copied text: ${feedItem.textContent}"
                }
            }
            InteractionType.LIKE -> {
                _interactionEvent.value = "Liked post by ${feedItem.username}"
            }
            InteractionType.COMMENT -> {
                _interactionEvent.value = "Commented on post by ${feedItem.username}"
            }
        }
    }
}

enum class InteractionType {
    CLICK, LONG_CLICK, LIKE, COMMENT
}
