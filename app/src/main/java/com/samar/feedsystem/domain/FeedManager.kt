import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.domain.FeedRepository
import com.samar.feedsystem.domain.ImageFeedItem
import com.samar.feedsystem.domain.InteractionType
import com.samar.feedsystem.domain.TextFeedItem
import com.samar.feedsystem.domain.VideoFeedItem

class FeedManager(private val feedRepository: FeedRepository) {

    // Fetch the feed data from the repository
    fun fetchFeed(): List<FeedItem> {
        return feedRepository.getFeedData()
    }

    // Handle interactions like click, long-click, like, and comment
    fun handleInteraction(feedItem: FeedItem, interactionType: InteractionType) {
        when (interactionType) {
            InteractionType.CLICK_IMAGE -> onItemClick(feedItem)
            InteractionType.LONG_CLICK -> onItemLongClick(feedItem)
            InteractionType.LIKE -> onItemLike(feedItem)
            InteractionType.COMMENT -> onItemComment(feedItem)
            InteractionType.CLICK_VIDEO -> onItemComment(feedItem)
        }
    }

    private fun onItemClick(feedItem: FeedItem) {
        when (feedItem) {
            is TextFeedItem -> println("Text clicked: ${feedItem.textContent}")
            is ImageFeedItem -> println("Image clicked: ${feedItem.imageUrls}")
            is VideoFeedItem -> println("Video clicked: ${feedItem.videoUrl}")
        }
    }

    private fun onItemLongClick(feedItem: FeedItem) {
        when (feedItem) {
            is TextFeedItem -> println("Text long-clicked: ${feedItem.textContent}")
            is ImageFeedItem -> println("Image long-clicked: ${feedItem.imageUrls}")
            is VideoFeedItem -> println("Video long-clicked: ${feedItem.videoUrl}")
        }
    }

    private fun onItemLike(feedItem: FeedItem) {
        println("Item liked: ${feedItem.id}")
    }

    private fun onItemComment(feedItem: FeedItem) {
        println("Item commented on: ${feedItem.id}")
    }
}
