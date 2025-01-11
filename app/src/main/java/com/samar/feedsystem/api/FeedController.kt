package com.samar.feedsystem.api

import androidx.test.espresso.remote.InteractionRequest
import com.samar.feedsystem.domain.FeedItem
import com.samar.feedsystem.service.FeedService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/feeds")
class FeedController(private val feedService: FeedService) {

    @GetMapping("/")
    fun getFeeds(): ResponseEntity<List<FeedItem>> {
        // Fetches all feed data using the service
        val feedItems = feedService.getAllFeeds()
        return ResponseEntity.ok(feedItems)
    }

    @PostMapping("/interaction")
    fun handleInteraction(@RequestBody interactionRequest: InteractionRequest): ResponseEntity<Void> {
        // Handles any interaction (like, comment, click, etc.)
        feedService.handleInteraction(interactionRequest.feedItem, interactionRequest.interactionType)
        return ResponseEntity.ok().build()
    }
}
