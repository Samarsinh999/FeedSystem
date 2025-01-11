package com.samar.feedsystem.api

import androidx.test.espresso.remote.InteractionRequest
import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.service.SocialMediaFeedService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/social-media-feeds")
class SocialMediaFeedController(private val socialMediaFeedService: SocialMediaFeedService) {

    @GetMapping("/{platform}")
    fun getFeedsForPlatform(@PathVariable platform: String): ResponseEntity<List<FeedItem>> {
        // Fetches feed data specific to the platform
        val platformFeeds = socialMediaFeedService.getPlatformFeeds(platform)
        return ResponseEntity.ok(platformFeeds)
    }

    @PostMapping("/interaction")
    fun handlePlatformInteraction(@RequestBody interactionRequest: InteractionRequest): ResponseEntity<Void> {
        // Handles interactions like, comment, etc., for platform-specific feeds
        socialMediaFeedService.handlePlatformInteraction(interactionRequest.feedItem, interactionRequest.interactionType)
        return ResponseEntity.ok().build()
    }
}
