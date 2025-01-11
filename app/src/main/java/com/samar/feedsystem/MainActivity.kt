package com.samar.feedsystem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.ads.mediationtestsuite.viewmodels.ViewModelFactory
import com.samar.feedsystem.adapter.FeedAdapter
import com.samar.feedsystem.domain.MockFeedRepository
import com.samar.feedsystem.viewModel.FeedViewModel
import com.samar.feedsystem.viewModel.InteractionType

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: FeedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ViewModel
        val repository = MockFeedRepository()
        viewModel = ViewModelProvider(this,
            com.samar.feedsystem.viewModel.ViewModelFactory(repository)
        ).get(FeedViewModel::class.java)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.feedRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe feed data
        viewModel.feedItems.observe(this) { feedItems ->
            adapter = FeedAdapter(feedItems,
                onClick = { feedItem -> viewModel.handleInteraction(feedItem, InteractionType.CLICK) },
                onLongClick = { feedItem -> viewModel.handleInteraction(feedItem, InteractionType.LONG_CLICK) }
            )
            recyclerView.adapter = adapter
        }

        // Observe interactions
        viewModel.interactionEvent.observe(this) { interactionMessage ->
            Toast.makeText(this, interactionMessage, Toast.LENGTH_SHORT).show()
        }

        // Fetch data
        viewModel.fetchFeedData()
    }
}
