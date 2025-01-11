package com.samar.feedsystem.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.samar.feedsystem.domain.FeedRepository

class ViewModelFactory(private val repository: FeedRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FeedViewModel::class.java)) {
            return FeedViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
